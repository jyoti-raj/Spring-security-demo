package com.learn.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	
	 @Id
	 String userName;
	 String password;
	 String email;
	 String role;

	public User() {
		
	}
	
	public User(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
