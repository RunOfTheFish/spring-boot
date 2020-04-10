package com.example.three;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {

    public static void main(String[] args) {

        // forEach();
        // thread();
        // reduce();
        // listToMap();
        // groupBy();

        String[] str = {"hello", "ok", "bye"};

        String[] str1 = {"hello1", "ok1", "bye1"};

        List<String> strList = Arrays.stream(str).collect(Collectors.toList());

        System.out.println(1);



    }

    public static void forEach() {
        List<String> list = Arrays.asList("篮球", "足球", "网球");

        list.stream().filter(e -> !e.equals("篮球")).map(x -> x + 1).collect(Collectors.toList()).forEach(g -> System.out.println(g));
    }

    public static void thread() {
        new Thread(() -> {
            System.out.println("xixixi - xixixi");
        }).start();
    }

    public static void reduce() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7);

        int sum = list.stream().map(x -> x + 1).reduce((x, y) -> x + y).get();

        System.out.println(sum);
    }

    public static void listToMap() {
        User user1 = new User();
        user1.setName("张三");
        user1.setSex(1);
        user1.setRemark("Z");

        User user2 = new User();
        user2.setName("李四");
        user2.setSex(2);
        user2.setRemark("L");

        List<User> userList = Arrays.asList(user1, user2);

        Map<String, User> userMap = userList.stream().collect(Collectors.toMap(User::getName, Function.identity()));

        userMap.forEach((k,v) -> System.out.println(k + "," + v.toString()));
    }

    public static void groupBy() {
        User user1 = new User();
        user1.setName("张三");
        user1.setSex(1);
        user1.setRemark("Z");

        User user2 = new User();
        user2.setName("李四");
        user2.setSex(2);
        user2.setRemark("L");

        User user3 = new User();
        user3.setName("张三");
        user3.setSex(3);
        user3.setRemark("Li");

        List<User> userList = Arrays.asList(user1, user2, user3);

        Map<String, List<User>> groupMap = userList.stream().sorted(Comparator.comparing(User::getSex).reversed()).collect(Collectors.groupingBy(User::getName));

        System.out.println(1);
    }

    @Data
    static class User {

        private String name;
        private Integer sex;
        private String remark;

    }

}
