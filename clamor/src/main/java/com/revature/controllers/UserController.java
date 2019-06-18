package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("id/{id}")
	public User getById(@PathVariable int id) {
		return userService.findById(id);
	}
	
	@PostMapping("")
	public User getUsernameAndPassword(@RequestBody String username, @RequestBody String password) {
		return userService.getLogin(username, password);
		
	}
	
	@PostMapping("")
	public User getUsername(@RequestBody String username) {
		return userService.getUser(username);
	}
}
