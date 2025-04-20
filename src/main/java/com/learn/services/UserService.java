package com.learn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.models.User;

@Service
public class UserService {
	
	List<User> userList = new ArrayList<>();
	
	public UserService() {
		userList.add(new User("abc", "abc", "abc@gmail.com"));
		userList.add(new User("xyz", "xyz", "abcxyz@gmail.com"));
	}
	
	public List<User> getAllUser(){
		return this.userList;
	}
	
	public User getUser(String username){
		return this.userList.stream().filter(user -> user.getUserName().equals(username)).findAny().orElse(null);
	}
	
	public User addUser(User user) {
		userList.add(user);
		return user;
	}
	

}
