package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring.demo.member"})
public class GradleMyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradleMyBatisApplication.class, args);
	}

}
