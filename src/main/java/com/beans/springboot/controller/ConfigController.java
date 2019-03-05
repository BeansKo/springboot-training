package com.beans.springboot.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beans.springboot.config.ServerSetting;

@RestController
@RequestMapping("config")
public class ConfigController {
	
	@Resource
	ServerSetting serverSetting;
	
	@GetMapping("get_config")
	public Object getConfig() {
		return serverSetting;
	}
}
