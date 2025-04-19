package com.learn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.models.User;
import com.learn.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public List<User> getUsers(){
		return this.userService.getAllUser();
	}
	
	@GetMapping("/{name}")
	public User getUserByName(@PathVariable("name") String username){
		return this.userService.getUser(username);
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user){
		return this.userService.addUser(user);
	}


}
