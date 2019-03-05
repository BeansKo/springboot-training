package com.beans.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor")
public class InterceptorController {
	@GetMapping("/test")
	public Object testInterceptor() {
		return "interceptor";
	}

}
