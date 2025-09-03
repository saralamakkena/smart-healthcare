package com.smarthealthcare.userservice.dto;

public class LoginRequest {
    private String userName;
    private String password;
    // getters and setters
	public String getUserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
