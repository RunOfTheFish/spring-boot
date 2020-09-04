package com.example.three;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.util.IdUtil;
import com.tg.supports.core.function.Snowflake;
import com.tg.supports.core.helper.RandomHelper;

public class IdTest {

    public static void main(String[] args) {
        String id = ObjectId.next();

        System.out.println(id);

        String id2 = IdUtil.objectId();

        System.out.println(id2);

        // 生成10位随机数
        String id3 = RandomHelper.string(6, "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ");
        System.out.println(id3);


        //new Snowflake(10, 10).id();
    }
}
