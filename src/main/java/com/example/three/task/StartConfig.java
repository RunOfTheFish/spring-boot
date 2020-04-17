package com.example.three.task;

import com.example.three.auth.cache.ProductPermissionsCache;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StartConfig implements ApplicationRunner {

    @Resource
    private ProductPermissionsCache cache;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        cache.put("user:del", "2020-04-30 23:59:59");
        cache.put("user:add", "2020-04-30 23:59:59");
        //cache.put("user:update", "2020-04-30 23:59:59");


    }
}
