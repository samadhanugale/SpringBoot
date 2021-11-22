package com.neo.demo.controller;


import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloControl {
	@GetMapping("/hello")
	public String helo() {
		return "Hello there : Spring project";
	}
	@GetMapping("/today")
	public String today() {
		return "Today is : "+new Date().toString();
	}
}
