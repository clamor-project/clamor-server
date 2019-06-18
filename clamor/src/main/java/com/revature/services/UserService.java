package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {
	List<User> findAll();
	
	User findById(int id);
	
	User getLogin(String username, String password);
	
	User getUser(String username);
	
	List<User> getUserFriends(int id);
}
