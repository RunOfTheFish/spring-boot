package com.example.three.service;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.three.bean.entity.Impower;
import com.example.three.bean.model.ProductType;
import com.example.three.bean.model.Response;
import com.example.three.mapper.ImpowerMapper;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ImpowerService {

    private static SimpleDateFormat sif = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    private ImpowerMapper impowerMapper;

    public Page<Impower> getPage(Page<Impower> page) {
        List<Impower> impowers = impowerMapper.selectPage(page);

        if (impowers != null && impowers.size() > 0) {
            for (Impower impower : impowers) {
                if (com.example.three.bean.explain.ProductType.BAIDU_FACE.getCode() == impower.getProductType()) {// 百度
                    impower.setProductName(com.example.three.bean.explain.ProductType.BAIDU_FACE.getDescription());
                } else if (com.example.three.bean.explain.ProductType.TX_FINGER.getCode() == impower.getProductType()) {// 腾讯
                    impower.setProductName(com.example.three.bean.explain.ProductType.TX_FINGER.getDescription());
                } else if (com.example.three.bean.explain.ProductType.ALI_CAR.getCode() == impower.getProductType()) {// 阿里
                    impower.setProductName(com.example.three.bean.explain.ProductType.ALI_CAR.getDescription());
                } else {// 未找到
                    impower.setProductName("未知");
                }

                if (impower.getState() == 0) {
                    impower.setStateName("未激活");
                } else {
                    impower.setStateName("已激活");
                }

                if (impower.getStartTime() != null && impower.getEndTime() != null) {
                    impower.setStartTimeStr(sif.format(impower.getStartTime()));
                    impower.setEndTimeStr(sif.format(impower.getEndTime()));
                }

            }
        }

        page.setRecords(impowers);
        return page;
    }

    public List<ProductType> getProductList() {
        List<ProductType> list = new ArrayList<>();

        com.example.three.bean.explain.ProductType[] eList = com.example.three.bean.explain.ProductType.values();

        for (int i = 0; i < eList.length; i++) {
            ProductType type = new ProductType();
            type.setCode(eList[i].getCode());
            type.setName(eList[i].getDescription());
            list.add(type);
        }

        return list;
    }

    public Integer save(Impower impower) {
        if (impower.getId() == null) {// 新增
            // 激活码
            impower.setKey(UUID.randomUUID().toString().replaceAll("-", ""));
            // 初始标记未使用
            impower.setState(0);
            return impowerMapper.insert(impower);
        } else {
            return impowerMapper.updateById(impower);
        }
    }

    public Response apiAuth(String json) {

        JSONObject object = JSON.parseObject(json);
        // 激活码
        String key = (String) object.get("key");

        Impower imp = new Impower();
        imp.setKey(key);
        imp = impowerMapper.selectOne(imp);


        if (imp == null) {// 不存在
            return new Response(false, "无效的激活码", null);
        }

        if (imp.getState() == 1) {// 激活码已使用
            return new Response(false, "当前激活码已在其他机器使用", null);
        }

        // mac 地址
        String mac = (object.get("mac") == null) ? null : (String) object.get("mac");
        // 硬盘地址
        String serial = (object.get("serial") == null) ? null : (String) object.get("serial");

        if (mac == null || serial == null) {
            return new Response(false, "验证参数缺失", null);
        }

        Map<String, String> sendMap = new HashMap<>();

        // 修改已使用
        imp.setState(1);

        RSA rsa = new RSA();
        // 公钥
        String publicKey = rsa.getPublicKeyBase64();
        // 私钥
        String privateKey = rsa.getPrivateKeyBase64();

        Date nowTime = new Date();

        Calendar now = Calendar.getInstance();
        now.setTime(nowTime);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + Integer.valueOf(imp.getBurnNum()));
        Date endTime = now.getTime();

        imp.setPublicKey(publicKey);
        imp.setPrivateKey(privateKey);
        imp.setPhysicalAddress(mac);
        imp.setDiskAddress(serial);

        imp.setReceiveInfo(json);

        imp.setStartTime(nowTime);
        imp.setEndTime(endTime);

        Map<String, Object> sendJsonMap = new HashMap<>();
        sendJsonMap.put("aa", 1);
        sendJsonMap.put("bb", 1);
        List<String> demo1 = new ArrayList<>();
        demo1.add("1");
        demo1.add("2");
        demo1.add("3");
        sendJsonMap.put("cc",  demo1);
        sendJsonMap.put("startTime", sif.format(nowTime));
        sendJsonMap.put("endTime", sif.format(endTime));
        sendJsonMap.put("key", key);
        sendJsonMap.put("mac", mac);
        sendJsonMap.put("serial", serial);

        // TODO 授权相关
        String sendJson = JSON.toJSONString(sendJsonMap);

        imp.setAuthInfo(sendJson);

        sendMap.put("publicKey", publicKey);
        byte[] bw = rsa.encrypt(StrUtil.bytes(sendJson, CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);

        String bwStr = HexUtils.toHexString(bw);

        sendMap.put("auth", bwStr);

        imp.setSendInfo(JSON.toJSONString(sendMap));

        impowerMapper.updateById(imp);

        return new Response(true, "ok", sendMap);
    }

}
