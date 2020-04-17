package com.example.three.auth.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ProductPermissionsCache {

    public Cache<String, String> cache;

    public String get(String key) {
        try {
            String var = cache.getIfPresent(key);
            return var;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    @PostConstruct
    public void init() {
        cache = CacheBuilder.newBuilder()
                //设置cache的初始大小为10000，要合理设置该值
                .initialCapacity(10000)
                //设置并发数为10，即同一时间最多只能有5个线程往cache执行写入操作
                .concurrencyLevel(10)
                //构建cache实例
                .build();
    }

    public void del(String key) {
        cache.invalidate(key);
    }

}
