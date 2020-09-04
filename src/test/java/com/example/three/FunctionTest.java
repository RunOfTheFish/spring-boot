package com.example.three;

import com.sun.org.apache.regexp.internal.RE;
import javafx.beans.property.StringProperty;
import lombok.Data;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        Function<Bean, Bean> function = e -> {
            Bean bean = new Bean();

            aa();

            return bean;
        };


//        new Dia(function).instance();
    }

    static class Dia {

        private String title = "abc";
        private String age = "12";

        public Dia(Function<String, String> function) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    function.apply("");
                    title = "123";

                }
            });
            thread.start();


            title = function.apply(title);
        }

        public void instance() {
            System.out.println(title);
        }

    }

    @Data
    static class Bean {
        private String title = "abc";
        private String age = "12";
    }

    public static void aa() {

    }
}
