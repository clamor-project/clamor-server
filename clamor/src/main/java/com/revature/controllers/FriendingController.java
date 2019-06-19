package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping(path = "add", consumes = "application/json", produces = "application/json")
	public void addFriends(@RequestBody int user_1, @RequestBody int user_2) {
		friendingService.addFriend(user_1, user_2);
	}
	
	@DeleteMapping(path = "delete", consumes = "application/json", produces = "application/json")
	public void deleteFriends(@RequestBody int user_1, @RequestBody int user_2) {
		friendingService.deleteFriend(user_1, user_2);
	}
	
}
