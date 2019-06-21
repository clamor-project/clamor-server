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
	
	@GetMapping("friends/{id}")
	public List<Friending> getFriends(@PathVariable int id){
		return friendingService.findUserFriends(id);
	}
	
	@GetMapping("requests/{id}")
	public List<Friending> getRequests(@PathVariable int id){
		return friendingService.findFriendRequests(id);
	}
	
	@PostMapping(path = "add", consumes = "application/json", produces = "application/json")
	public void addFriends(@RequestBody Friending friending) {
		friendingService.addFriend(friending.getUser1().getId(), friending.getUser2().getId());
	}
	
	@DeleteMapping(path = "delete", consumes = "application/json", produces = "application/json")
	public void deleteFriends(@RequestBody Friending friending) {
		friendingService.deleteFriend(friending.getUser1().getId(), friending.getUser2().getId());
	}
	
}
 