package com.example.three;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MySpringBootThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootThreeApplication.class, args);
	}
}
