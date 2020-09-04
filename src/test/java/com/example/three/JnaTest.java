package com.example.three;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.three.jna.AuthDecode;
import com.example.three.jna.AuthEncrypt;
import com.example.three.jna.AuthResult;

public class JnaTest {

    /*public static void main(String[] args) {
        System.setProperty("jna.library.path", "D:\\dll");
        System.setProperty("jna.debug_load", "true");
        System.setProperty("jna.encoding", "GBK");

        String pri = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQD0hi2bs9EqGAKut0XIWIRydpG6SyC90aEDzbVgAIACA/NpP62ltkFsGuBPOzTu485JnBRJk8LjxtW+WZzIHT+20rfYMVLUrFl43k7xzVWHmMY1S+ZkyMv61Nj7wFQJjZKbXauZmfMDSP14JxS+KnkDQUze1oZQCXEviABfGHOQj2Pp3kb0bzrXUrwiOIh5S0+TShu2SXuFP7n3A7Y71iLncCt7KWxESx+mk7KHQ2IUSY8KJv7V0l/wqFDHBSOuoxLfjY0khUpDCrPIGJZPeYvC9qIbjQakkvphtGXu9hq5l1c+MSnbA7GQrmCnNp1+17xtaHt6WBy4+NW0lBEU9tzHAgMBAAECggEAbORH8Tu9nNI+d5HUOKj6qoKU2PJV7VIqMyhragou9zbNMgSSjuY/8iVx2LbUFsJJ/kvMWQu9UXQdgXwkrpUf54mlJ1inu1/ZJFNTsqivOwhU1C0tt5oYBGa/DjWS9wId1KR9I5UEPGVHwzccLKd7ZnCxC9dazs+1oOYezDp2VFw31p/drx2vZZPVLNZ7mDm99HaApc7OeAjk0kSTAKCLtJsnhiYyuopDDn6znrqt7P/3hwLpEaqj+QPOJC0zIu+XdbFufJrw45vf6GYYjh03Mll9uTVbYv4LPPxgLpui+6px3B/zTT9yP8KaC2gKKQ014O/RrWAFvU8EV8vWMHHmiQKBgQD9K+HIxRGvqarfuOc7veR5O8F0WCEJvvZ3I3go9TPaIDVPGA1g7SIN8gLRwoKfAdJp75lIzToE0JrmpaHVnLcoOH5lEk/61ZBEvQ3WUaz3avmlNGJlfetetERE7wPhm2WFbUYhR0kc2av6k8eesv1Rs/VQ+OcDans44r3aejXy9QKBgQD3QZA2lRY1Ub+7EsVadlJ6C4hLDW2/JEefO+pPNMLk8C+WlHGRmfBdNrH2rSMakCwtj0zTnX8AFmWTrErdTP35UzQQ4yvHqhDjlKI8hTeyJQ3a6CO0Ffwe6NoEvxueudEtjbYnhYneIbD0s9kwPb2jRhjJW668cD78d5e5bk6TSwKBgGrQEshj7JxSVxdgqZ5Y9YX4ohv1+qpj+RQ20MFnAmNq51LhcPON2KpNisb466cuW5n6To+alnnlkRTymJ7JKbU8cIcv/LJ1XBLEOIxNlU4lwgHjYggz4hPotkznEpoit+hdPBNaQgx8AcUMiFH6bkoEROHOwZh9WlObxkHhAdXpAoGAQN9v4hJNyGGRh5jONQT0cNcTxHVahRsUu5+xw2RZek3WfpCmF4inOx29pbYZjr+jB7UgeClLiA9YSV2cKuInhMIi2Adylil10vBNfMmLKm90aiocLATUqJt5kGM/8O5aBrS2xTnRSXnXfuytIG4iknMyz6oBd6mPrRgHs/xQG28CgYEA97a8JDTOggpqmveQ0VZP93VZ/2GQyJmRZ8k7t2OJqypbkGwy9L7PDmoHrdVHTV+uJYbDTSa9UZ0j9V8jNjpoL9fqv9vUKc2+vv14bmET/IIy9fbDYbNSWXeSkwVRm6Kb9JGg1fMmee76g6ch0PSsL9i1wNWe+bb1BWgkirCdxS0=";
        String pub = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA9IYtm7PRKhgCrrdFyFiEcnaRuksgvdGhA821YACAAgPzaT+tpbZBbBrgTzs07uPOSZwUSZPC48bVvlmcyB0/ttK32DFS1KxZeN5O8c1Vh5jGNUvmZMjL+tTY+8BUCY2Sm12rmZnzA0j9eCcUvip5A0FM3taGUAlxL4gAXxhzkI9j6d5G9G8611K8IjiIeUtPk0obtkl7hT+59wO2O9Yi53AreylsREsfppOyh0NiFEmPCib+1dJf8KhQxwUjrqMS342NJIVKQwqzyBiWT3mLwvaiG40GpJL6YbRl7vYauZdXPjEp2wOxkK5gpzadfte8bWh7elgcuPjVtJQRFPbcxwIDAQAB";

        String two = "{'eventId':'393284669688991744106d3444101c41','eventName':'receiveCommand','eventTime':637185035741290000,'eventData':{'destDevList':['54CF048A638E1DCB274CD8F5E4846179'],'devSpecToken':'f924aece-91fc-4eb2-9426-77b8e2ba92b5','cmdTime':'1582877982372','cmdName':'CMD_BUSI_ZNWXBGG_pushVerifiEmpeInfResult2Device','cmdParas':{'mnpltStffId':'96016770','cmpRsltInd':'1'},'cmdMetaInfo':{}}}";

        RSA rea = new RSA(pri, pub);

        two = rea.encryptBase64(two, KeyType.PrivateKey);

        String encrypt = AuthEncrypt.INSTANCE.encrypt(pub, two);

        JSONObject jsonObject = (JSONObject) JSONObject.parse(encrypt);

        String data = (String)jsonObject.get("data");

        System.out.println(data);

        System.out.println("加密：" + encrypt);

        String decode = AuthDecode.INSTANCE.decode(data);

        JSONObject re01 = JSONObject.parseObject(decode);
        JSONObject re02 = re01.getJSONObject("data");
        String re03 = (String)re02.get("content");

        String re002 = rea.decryptStr(re03, KeyType.PublicKey);

        System.out.println(re002);

        System.out.println("解密：" + decode);
    }*/

    public static void main(String[] args) {
        System.setProperty("jna.library.path", "D:\\dll");
        System.setProperty("jna.debug_load", "true");
        System.setProperty("jna.encoding", "GBK");

        String mk = "QOeQ344vbjobrbgjgzQOVt8ZgeBUO56sictindelzOEQJHsS5G9Qt3y/fHFfUaGPtZar82ARWghzOdRHAiQOFpC3KvI+QIBmVCTdb5u7CuwUDqalN/3NeNVi9I072Avljnw5vCIiGpoLiZVnq+1tTsl1lvT/EYGgbkAYjR0ODbGn1Zfw+UUfPN/2ziIzVQDcqhlF+7KinS8mTo5s2Cu9XgLVyqxPMYZQG/+v323gQHyQimKJDTMmlQWFVRbkn+kZlbdw6bQx7FWwaC0aKj7Kb3EahimAqVKLB6CxNh9KR40BgLlelXAG9n/3FVYKrun1zLqkGGZa0GQmjlidlqcl2AzIcpJHxVT3xyiZTIk2JBcEcwcrSvb1og3ct00kLk1MaHzZss2Lm8Y9Ue+SzacFdSfFqmFxLwi0dNFJDECKFsvxmmN5cfvDvXca4EAuobNu6zJ761D+VVfmBKyoK08tEyeX/x7v55AZa1S62+gRsuEtWIfZ2QqG6c0yEbL4KCzPo5Mm9xnZ5ULgJ8M7miNhXsv/EF+FesGkRwoBanvOhfe+4PzR2GMyy6A8CJ7vfWqu/J+dwGTVeDEOY6b7imZUYxToPVdsUbedBffv1AfwmpT66PDiGm1LZUAHYimGL751zbWlJAIOjuOxkKa8Y8b6QBGNOEgEKQqX+UX19M2ki2Y=";

        String encrypt = AuthEncrypt.INSTANCE.replaceEncrypt(mk);

        System.out.println(encrypt);

        JSONObject AA = JSON.parseObject(encrypt);

        JSONObject jsonObject = (JSONObject) JSONObject.parse(encrypt);

        JSONObject data = jsonObject.getJSONObject("data");

        String aa = data.toJSONString();

        String key = (String)data.get("key");
        String context = (String)data.get("context");
        String contextMd5 = data.getString("contextMd5");

        System.out.println("key:" + key);
        System.out.println("context:" + context);
        System.out.println("contextMd5:" + contextMd5);
    }

/*    public static void main(String[] args) {

        System.setProperty("jna.library.path", "D:\\dll");
        System.setProperty("jna.debug_load", "true");
        System.setProperty("jna.encoding", "GBK");

        String one = "QVzUAb9ibPnMD6hgz2JL";
        String two = "A0-D3-7A-DB-22-70,E813-E620";

        String encrypt = AuthEncrypt.INSTANCE.signature(one, two);

        AuthResult result = JSON.toJavaObject(JSON.parseObject(encrypt), AuthResult.class);

        JSONObject jsonObject = (JSONObject) JSONObject.parse(encrypt);

        String data = (String)jsonObject.get("data");

        System.out.println(data);

    }*/

    /*public static void main(String[] args) {
        System.setProperty("jna.library.path", "D:\\dll");
        System.setProperty("jna.debug_load", "true");
        System.setProperty("jna.encoding", "GBK");

        String key = "qwee12wsrfvb120o";
        String feature = "A0-D3-7A-DB-22-70,E813-E620";
        String message = "YOeQ344vbjobrbgjgzQOHt8ZgeBUO56sictindelXOEQJHsS5G9Qt3y/fHFfuaGPtZar82ARWghzOdRHGiQOFpC3KvI+QIBmVCTdh5u7CuwUDqalN/3NeNViKI072Avljnw5vCIiGpoLAZVnq+1tTsl1lvT/EYGgokAYjR0ODbGn1Zfw+UUfVN/2ziIzVQDcqhlF+7KiGS8mTo5s2Cu9XgLVyqxPqYZQG/+v323gQHyQimKJZTMmlQWFVRbkn+kZlbdwrbQx7FWwaC0aKj7Kb3Ea3imAqVKLB6CxNh9KR40B3LlelXAG9n/3FVYKrun1bLqkGGZa0GQmjlidlqcliAzIcpJHxVT3xyiZTIk2uBcEcwcrSvb1og3ct00klk1MaHzZss2Lm8Y9Ue+SzacFdSfFqmFxLwi0dNFJDECKFsvxmmN5cfvDvXca4EAuobNu6zJ761D+VVfmBKyoK08tEyeX/x7v55AZa1S62+gRsuEtWIfZ2QqG6c0yEbL4KCzPo5Mm9xnZ5ULgJ8M7miNhXsv/EF+FesGkRwoBanvOhfe+4PzR2GMyy6A8CJ7vfWqu/J+dwGTVeDEOY6b7imZUYxToPVdsUbedBffv1AfwmpT66PDiGm1LZUAHYimGL751zbWlJAIOjuOxkKa8Y8b6QBGNOEgEKQqX+UX19M2ki2Y=";

        String encrypt = AuthDecode.INSTANCE.packageKeyInfo(key, feature, message);

        AuthResult result = JSON.toJavaObject(JSON.parseObject(encrypt), AuthResult.class);

        JSONObject jsonObject = (JSONObject) JSONObject.parse(encrypt);

        String data = (String)jsonObject.get("data");

        System.out.println(data);
    }*/

/*    public static void main(String[] args) {

        System.setProperty("jna.library.path", "D:\\dll");
        System.setProperty("jna.debug_load", "true");
        System.setProperty("jna.encoding", "GBK");

        String key = "QVzUAb9ibPnMD6hgz2JL55529f3d42";
        String message = "YOeQ344vbjobrbgjgzQOHt8ZgeBUO56sictindelXOEQJHsS5G9Qt3y/fHFfuaGPtZar82ARWghzOdRHGiQOFpC3KvI+QIBmVCTdh5u7CuwUDqalN/3NeNViKI072Avljnw5vCIiGpoLAZVnq+1tTsl1lvT/EYGgokAYjR0ODbGn1Zfw+UUfVN/2ziIzVQDcqhlF+7KiGS8mTo5s2Cu9XgLVyqxPqYZQG/+v323gQHyQimKJZTMmlQWFVRbkn+kZlbdwrbQx7FWwaC0aKj7Kb3Ea3imAqVKLB6CxNh9KR40B3LlelXAG9n/3FVYKrun1bLqkGGZa0GQmjlidlqcliAzIcpJHxVT3xyiZTIk2uBcEcwcrSvb1og3ct00klk1MaHzZss2Lm8Y9Ue+SzacFdSfFqmFxLwi0dNFJDECKFsvxmmN5cfvDvXca4EAuobNu6zJ761D+VVfmBKyoK08tEyeX/x7v55AZa1S62+gRsuEtWIfZ2QqG6c0yEbL4KCzPo5Mm9xnZ5ULgJ8M7miNhXsv/EF+FesGkRwoBanvOhfe+4PzR2GMyy6A8CJ7vfWqu/J+dwGTVeDEOY6b7imZUYxToPVdsUbedBffv1AfwmpT66PDiGm1LZUAHYimGL751zbWlJAIOjuOxkKa8Y8b6QBGNOEgEKQqX+UX19M2ki2Y=";
        String feature = "A0-D3-7A-DB-22-70,E813-E620";

        String encrypt = AuthDecode.INSTANCE.offLineDecode(key, message, feature);

        AuthResult result = JSON.toJavaObject(JSON.parseObject(encrypt), AuthResult.class);

        System.out.println("::" + encrypt);

        JSONObject jsonObject = (JSONObject) JSONObject.parse(encrypt);

        String data = (String)jsonObject.get("data");

        System.out.println(data);

    }*/
}
