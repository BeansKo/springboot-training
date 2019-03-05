package com.beans.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beans.springboot.domain.User;

/**
 * 测试Jackson控制返回数据
 * @author Frank
 *
 */
@RestController
public class JsonController {
	@GetMapping("/get_json")
	public Object getJson() {
		return new User(null,"9999","10010",20,new java.util.Date());
	}
}
