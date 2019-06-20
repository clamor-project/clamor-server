package com.revature.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;

@RestController
@RequestMapping("users")
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping
	public User getUser() {
		return new User(-4, "Johnathon Depth");
	}
}
