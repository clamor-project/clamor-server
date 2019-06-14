package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.UserGroup;
import com.revature.services.UserGroupService;

@RestController
@RequestMapping("usergroup")
public class UserGroupController {

	private UserGroupService userGroupService;

	@Autowired
	public UserGroupController(UserGroupService userGroupService) {
		super();
		this.userGroupService = userGroupService;
	}
	
	// this will probably not appear in the production application
	@GetMapping
	public List<UserGroup> findAll() {
		return userGroupService.findAll();
	}
	
	@GetMapping("id/{id}")
	public UserGroup findById(@PathVariable int id) {
		return userGroupService.findById(id);
	}
}
