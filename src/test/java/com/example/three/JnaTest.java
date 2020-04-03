package com.example.three;

import com.alibaba.fastjson.JSONObject;
import com.example.three.jna.AuthDecode;
import com.example.three.jna.AuthEncrypt;

public class JnaTest {

    public static void main(String[] args) {
        System.setProperty("jna.library.path", "D:\\dll");
        System.setProperty("jna.debug_load", "true");
        System.setProperty("jna.encoding", "GBK");

        String one = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA9IYtm7PRKhgCrrdFyFiEcnaRuksgvdGhA821YACAAgPzaT+tpbZBbBrgTzs07uPOSZwUSZPC48bVvlmcyB0/ttK32DFS1KxZeN5O8c1Vh5jGNUvmZMjL+tTY+8BUCY2Sm12rmZnzA0j9eCcUvip5A0FM3taGUAlxL4gAXxhzkI9j6d5G9G8611K8IjiIeUtPk0obtkl7hT+59wO2O9Yi53AreylsREsfppOyh0NiFEmPCib+1dJf8KhQxwUjrqMS342NJIVKQwqzyBiWT3mLwvaiG40GpJL6YbRl7vYauZdXPjEp2wOxkK5gpzadfte8bWh7elgcuPjVtJQRFPbcxwIDAQAB";

        String two = "{'eventId':'393284669688991744106d3444101c41','eventName':'receiveCommand','eventTime':637185035741290000,'eventData':{'destDevList':['54CF048A638E1DCB274CD8F5E4846179'],'devSpecToken':'f924aece-91fc-4eb2-9426-77b8e2ba92b5','cmdTime':'1582877982372','cmdName':'CMD_BUSI_ZNWXBGG_pushVerifiEmpeInfResult2Device','cmdParas':{'mnpltStffId':'96016770','cmpRsltInd':'1'},'cmdMetaInfo':{}}}";

        String encrypt = AuthEncrypt.INSTANCE.encrypt(one, two);

        JSONObject jsonObject = (JSONObject) JSONObject.parse(encrypt);

        String data = (String)jsonObject.get("data");

        System.out.println(data);

        System.out.println("加密：" + encrypt);

        String decode = AuthDecode.INSTANCE.decode(data);

        System.out.println("解密：" + decode);
    }
}
