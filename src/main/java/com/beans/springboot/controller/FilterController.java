package com.beans.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class FilterController {
	@GetMapping("/v1/filter_test")
	public Object test_Filter() {
		return "pass";
	}
}
