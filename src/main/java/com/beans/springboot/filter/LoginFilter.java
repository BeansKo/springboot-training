package com.beans.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/filter/*",filterName="LoginFilter")
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		System.out.println("LoginFilter-->init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter-->doFilter");
		HttpServletRequest req = (HttpServletRequest)request;
		String userName = req.getParameter("username");
		if("frank".equalsIgnoreCase(userName)){
			chain.doFilter(request, response);
		} else {
			return;
		}
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
		System.out.println("LoginFilter-->destroy");
	}
}
