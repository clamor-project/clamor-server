package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Conversions;
import com.revature.dtos.UsergroupDTO;
import com.revature.exceptions.IncorrectLoginException;
import com.revature.exceptions.IncorrectRegistrationException;
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
	
	@GetMapping("friends/{id}")
	public List<User> getUserFriends(@PathVariable int id){
		return userService.getUserFriends(id);
	}
	
	@GetMapping("friends/request/{id}")
	public List<User> getFriendRequest(@PathVariable int id){
		return userService.getFriendRequest(id);
	}
	
	
	@PostMapping("")
	public User getUsernameAndPassword(@RequestBody String username, @RequestBody String password) {
		return userService.getLogin(username, password);
		
	}
	
	@PostMapping("user")
	public User getUsername(@RequestBody String username) {
		return userService.getUser(username);
  }

	// will eventually infer id based off of client data
	@GetMapping("groups/{id}")
	public List<UsergroupDTO> findGroupsByUserId(@PathVariable int id){
		List<Usergroup> retList = usergroupService.findByUserId(id);
		return Conversions.convertUsergroupPrivate(retList);
	}
	

	@PostMapping(path="register", consumes = "application/json", produces = "application/json")
	public User registerUser(@RequestBody User u){
		User user = userService.save(u.getUsername(), u.getPassword(), u.getEmail(), u.getDateOfBirth());
		if(user.getId() != 0) {
			return user;
		} else {
			throw new IncorrectRegistrationException();
		}
	}

}

