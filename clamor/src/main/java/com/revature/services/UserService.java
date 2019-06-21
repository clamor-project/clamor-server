package com.revature.services;

import java.util.Date;
import java.util.List;

import com.revature.models.User;

public interface UserService {
	List<User> findAll();
	
	User findById(int id);
	
	User getLogin(String username, String password);
	
	User save(String username, String password, String email, Date dob);
	
	User getUser(String username);
	
	List<User> getUserFriends(int id);
	
	List<User> getFriendRequest(int id);
	
	List<User> getPotentialFriends(int id);
}
