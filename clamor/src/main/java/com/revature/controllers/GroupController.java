package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Group;
import com.revature.services.GroupService;

@RestController
@RequestMapping("group")
public class GroupController {

	private GroupService groupService;

	@Autowired
	public GroupController(GroupService groupService) {
		super();
		this.groupService = groupService;
	}
	
	@GetMapping
	public List<Group> findAll() {
		return groupService.findAll();
	}
	
	@GetMapping("id/{id}")
	public Group findById(@PathVariable int id) {
		return groupService.findById(id);
	}
	
}
