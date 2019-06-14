package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.GroupMessage;
import com.revature.services.GroupMessageService;

@RestController
@RequestMapping("groupmessage")
public class GroupMessageController {

	private GroupMessageService groupMessageService;

	@Autowired
	public GroupMessageController(GroupMessageService groupMessageService) {
		super();
		this.groupMessageService = groupMessageService;
	}
	
	// this route will probably not be in the final version
	@GetMapping
	public List<GroupMessage> findAll(){
		return groupMessageService.findAll();
	}
	
	@GetMapping("id/{id}")
	public GroupMessage findById(@PathVariable int id) {
		return groupMessageService.findById(id);
	}
	
}
