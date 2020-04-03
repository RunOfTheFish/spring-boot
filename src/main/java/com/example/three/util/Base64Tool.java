package com.example.three.util;

import org.apache.tomcat.util.codec.binary.Base64;

public class Base64Tool {

    private static Integer num = 11;

    /**
     * 加密
     * @param data
     * @return
     */
    public static String encode(String data) {
        String result = "";
        for(int i = 0; i < num; i++) {
            byte[] encode = Base64.encodeBase64(data.getBytes());
            result = new String(encode);
        }
        return result;
    }

    /**
     * 解密
     * @param data
     * @return
     */
    public static String decode(String data) {
        String result = "";
        for(int i = 0; i < num; i++) {
            byte[] decode = Base64.decodeBase64(data.getBytes());
            result = new String(decode);
        }
        return result;
    }

}
