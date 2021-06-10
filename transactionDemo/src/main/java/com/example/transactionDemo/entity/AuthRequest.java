package com.example.transactionDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthRequest {
	
	
	private String userName;
	
	private String password;
	private String accessToken;
	
	
	
	public AuthRequest(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	

}
