package com.example.demo;

import java.util.List;

public class UserRequest {
	private List<String> username;

	public List<String> getUsername() {
		return username;
	}

	public void setUsername(List<String> username) {
		this.username = username;
	}

	public UserRequest(List<String> username) {
		super();
		this.username = username;
	}

	public UserRequest() {
		super();
	}
	

}
