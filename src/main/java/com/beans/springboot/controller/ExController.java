package com.beans.springboot.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beans.springboot.domain.MyException;
import com.beans.springboot.domain.User;

@RestController
public class ExController {
	
	@RequestMapping("/v1/test_ex")
	public Object testException() {
		int age = 30/0;
		return new User("frank","123456","18991236098",age,new Date());
	}
	
	@GetMapping("/v1/test_myex")
	public Object testMyException() {
		throw new MyException("500","my exception.");
	}
}
