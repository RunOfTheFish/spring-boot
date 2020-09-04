package com.example.three;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

public class RsaTest {

    public static void main(String[] args) {

        RSA rsa = new RSA();

        System.out.println("private:" + rsa.getPrivateKeyBase64() + "\n" + "public:" + rsa.getPublicKeyBase64());

        String text = "{\"data\":[{\"functions\":[{\"name\":\"ql:auth:edit\",\"time\":\"2020-12-01 12:01:01\"}],\"logo\":\"XX\"},{\"functions\":[{\"name\":\"ql:user:add\",\"time\":\"2020-12-01 12:01:01\"},{\"name\":\"ql:user:edit\",\"time\":\"2020-12-01 12:01:01\"},{\"name\":\"ql:user:del\",\"time\":\"2020-12-01 12:01:01\"},{\"name\":\"ql:user:select\",\"time\":\"2020-12-01 12:01:01\"}],\"logo\":\"QL\"}],\"mac\":\"A0-D3-7A-DB-22-70\",\"serial\":\"E813-E620\"}";

        String s1 = rsa.encryptBase64(text, KeyType.PrivateKey);

        System.out.println("s1:" + s1);

        String e1 = rsa.decryptStr(s1, KeyType.PublicKey);

        System.out.println("e1:" + e1);

    }
}
