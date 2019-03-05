package com.beans.springboot.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements Serializable{

	private static final long serialVersionUID = 2879236139962358160L;

	@JsonInclude(Include.NON_NULL)
	private String userName;
	@JsonIgnore
	private String userPwd;
	@JsonProperty(value="df")
	private String userTelphone;
	private int age;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
	private Date createDate;
	
	public User() {
		super();
	}

	public User(String userName, String userPwd, String userTelphone, int age, Date date) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.userTelphone = userTelphone;
		this.age = age;
		this.createDate = date;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserTelphone() {
		return userTelphone;
	}

	public void setUserTelphone(String userTelphone) {
		this.userTelphone = userTelphone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPwd=" + userPwd + ", userTelphone=" + userTelphone + ", age=" + age
				+ ", createDate=" + createDate + "]";
	}
	
}
