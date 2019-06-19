package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Friending;
import com.revature.services.FriendingService;

@RestController
@RequestMapping("friending")
public class FriendingController {

	private FriendingService friendingService;

	@Autowired
	public FriendingController(FriendingService friendingService) {
		super();
		this.friendingService = friendingService;
	}
	
	// dev only
	@GetMapping
	public List<Friending> findAll(){
		return friendingService.findAll();
	}

	@GetMapping("id/{id}")
	public Friending findById(@PathVariable int id) {
		return friendingService.findById(id);
	}
	
}
