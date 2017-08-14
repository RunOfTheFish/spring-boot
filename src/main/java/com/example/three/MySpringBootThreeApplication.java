package com.example.three;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.three.mapper")
public class MySpringBootThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootThreeApplication.class, args);
	}
}
