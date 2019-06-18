package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Conversions;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.IncorrectLoginException;
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
		if(retUser.getId() == 0) {
			throw new IncorrectLoginException();
		} else {
			return Conversions.convertUserPrivate(retUser);
		}
	}
}
