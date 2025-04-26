package com.example.springboot.mongodb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithMangoDbApplication {
	@Value("${spring.application.name}")
	private static String appName;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMangoDbApplication.class, args);
		System.out.println("appname--"+ appName);
	}

}
