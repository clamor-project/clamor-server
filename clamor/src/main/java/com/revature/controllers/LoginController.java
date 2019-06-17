package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Conversions;
import com.revature.dtos.UserDTO;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {

	private UserService userService;
	
	@Autowired
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	public UserDTO login(@RequestBody User user) {
		User retUser = userService.getLogin(user.getUsername(), user.getPassword());
		return Conversions.convertUserPrivate(retUser);
	}
}
