package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Usergroup;
import com.revature.services.UsergroupService;

@RestController
@RequestMapping("usergroup")
public class UsergroupController {

	private UsergroupService usergroupService;

	@Autowired
	public UsergroupController(UsergroupService usergroupService) {
		super();
		this.usergroupService = usergroupService;
	}
	
	// this will probably not appear in the production application
	@GetMapping
	public List<Usergroup> findAll() {
		return usergroupService.findAll();
	}
	
	@GetMapping("id/{id}")
	public Usergroup findById(@PathVariable int id) {
		return usergroupService.findById(id);
	}
}
