package com.beans.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beans.springboot.domain.User;

/**
 * Get请求方式
 * @author Frank
 *
 */
@RestController
@RequestMapping("/v1")
public class GetController {
	private Map<String, Object> params = new HashMap<>();
	
	/**
	 * 功能描述：测试restful协议，从路径中获取字段
	 * 请求地址：http://localhost:9999/v1/chifeng/xinyu
	 * @param cityId
	 * @param userId
	 * @return
	 */
	@RequestMapping(path="/{city_id}/{user_id}",method = RequestMethod.GET)
	public Object finUser(@PathVariable("city_id") String cityId, @PathVariable("user_id") String userId) {
		params.clear();
		params.put("cityId", cityId);
		params.put("userId", userId);
		
		return params;
	}
	
	/**
	 * 功能描述：测试GetMapping
	 * 请求地址：http://localhost:9999/v1/page_user1?from=0&size=10
	 * @param from
	 * @param size
	 * @return
	 */
	@GetMapping(value="/page_user1")
	public Object pageUserV1(int from, int size) {
		params.clear();
		params.put("from", from);
		params.put("size", size);
		return params;
	}
	
	/**
	 * 功能描述：默认值，是否必须的参数
	 * @param from
	 * @param size
	 * @return
	 */
	@GetMapping(value="/page_user2")
	public Object pageUserV2(@RequestParam(defaultValue="0",name="page") int from, @RequestParam(required=true)int size) {
		params.clear();
		params.put("from", from);
		params.put("size", size);
		return params;
	}
	
	/**
	 * 功能描述:bean对象传参
	 * 注意： 1、注意需要指定http头为content-type为application/json
	 * 		 2、用body传输数据
	 * @param user
	 * @return
	 */
	@RequestMapping("/save_user")
	public Object saveUser(@RequestBody User user){
		params.clear();
		params.put("user", user);
		return params;	
	}
	
	/**
	 * 功能描述：测试获取http头信息
	 * @param accessTocken
	 * @param id
	 * @return
	 */
	@GetMapping(path="/get_header")
	public Object getHeader(@RequestHeader("access_tocken")String accessTocken, String id) {
		params.clear();
		params.put("access_tocken", accessTocken);
		params.put("id", id);
		return params;
	}
	
	@GetMapping("/test_request")
	public Object testRequest(HttpServletRequest request) {
		params.clear();
		String id = request.getParameter("id");
		params.put("id", id);
		return params;
	}
}
