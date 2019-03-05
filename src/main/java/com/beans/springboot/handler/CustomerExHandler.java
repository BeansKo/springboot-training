package com.beans.springboot.handler;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.beans.springboot.domain.JsonData;
import com.beans.springboot.domain.MyException;

@RestControllerAdvice
public class CustomerExHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerExHandler.class);
	
	@ExceptionHandler(value=Exception.class)
	public Object exceptionHandler(Exception e,HttpServletRequest request) {
		logger.error("url {},msg {}.",request.getRequestURL(),e.getMessage());
		return new JsonData(100,e.getMessage());
	}
	
	@ExceptionHandler(value=MyException.class)
	public Object myExceptionHandler(MyException e, HttpServletRequest request) {
		logger.error("url {},msg {}.",request.getRequestURL(),e.getMessage());
		
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("code", e.getCode());
		map.put("msg", e.getMessage());
		
		return map;
	}
}
