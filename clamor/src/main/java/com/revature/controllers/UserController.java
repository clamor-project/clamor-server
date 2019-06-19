package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.models.Usergroup;
import com.revature.services.UserService;
import com.revature.services.UsergroupService;

@RestController
@RequestMapping("user")
public class UserController {

	private UserService userService;
	private UsergroupService usergroupService;

	@Autowired
	public UserController(UserService userService, UsergroupService usergroupService) {
		super();
		this.userService = userService;
		this.usergroupService = usergroupService;
	}
	
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("id/{id}")
	public User getById(@PathVariable int id) {
		return userService.findById(id);
	}
	
	// will eventually infer id based off of client data
	@GetMapping("groups/{id}")
	public List<Usergroup> findGroupsByUserId(@PathVariable int id){
		List<Usergroup> retList = usergroupService.findByUserId(id);
		//return Conversions.convertUsergroupPrivate(retList);
		return retList;
	}
}
