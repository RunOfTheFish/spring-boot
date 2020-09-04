package com.example.three;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonTest {

    public static void main(String[] args) {

        String json = "{\"mac\":\"123123qwe123\",\"serial\":\"123qweq123qqqq\",\"data\":[{\"logo\":\"QL\",\"functions\":[{\"name\":\"user\",\"time\":\"2020-04-30 23:59:59\"},{\"name\":\"open\",\"time\":\"2020-04-30 23:59:59\"}]},{\"logo\":\"XX\",\"functions\":[{\"name\":\"user\",\"time\":\"2020-04-30 23:59:59\"},{\"name\":\"open\",\"time\":\"2020-04-30 23:59:59\"}]},{\"logo\":\"MJ\",\"functions\":[{\"name\":\"user\",\"time\":\"2020-04-30 23:59:59\"},{\"name\":\"open\",\"time\":\"2020-04-30 23:59:59\"}]}]}";

        /*JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject dataJson = jsonObject.getJSONObject("data");
        JSONObject qlJson = dataJson.getJSONObject("QL");

        System.out.println(qlJson);*/


        AuthIfo authIfo = JSON.toJavaObject(JSON.parseObject(json), AuthIfo.class);

        //AuthIfo authIfo = JSON.parseObject(json, new TypeReference<AuthIfo>(){});

        List<Function> functionList = authIfo.getData().stream().filter(x -> x.logo.equals("QL")).flatMap(x -> x.getFunctions().stream()).collect(Collectors.toList());



        System.out.println(authIfo);
    }

    @Data
    static class AuthIfo {
        private String mac;
        private String serial;
        private List<Product> data;
    }

    @Data
    static class Product {
        private String logo;
        private List<Function> functions;
    }

    @Data
    static class Function {
        private String name;
        private String time;
    }

}
