package com.neo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //Enables Spring Cache Functionality
public class SpringBootTest2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTest2Application.class, args);
	}

}
