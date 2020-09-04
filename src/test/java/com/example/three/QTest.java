package com.example.three;

import lombok.Data;

public class QTest {

    public static void sayHello(Bean bean, Greet greet) {
        greet.say(bean);
    }

    // 自定义 sayHello 里面的 say 方法的实现
    public static void selfSayImpl(Bean bean) {
        // 省略大段代码。。。
        System.out.println("Hello " + bean.getName());
        // 省略大段代码。。。
    }

    public static void main(String[] args) {
        Bean bean = new Bean();
        bean.setName("ye qing");
        QTest.sayHello(bean, (x) -> {
            QTest.selfSayImpl(x);
        });
    }

}

@FunctionalInterface
interface Greet {
    void say(Bean bean);
}

@Data
class Bean {
    String name;
    String value;
}
