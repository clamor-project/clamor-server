package com.revature.services;

import java.util.List;

import com.revature.models.Friending;

public interface FriendingService {
	List<Friending> findAll();
	
	Friending findById(int id);
	
	//to add friends and accept friends
	void addFriend(int user_1, int user_2);
	
	//deleting friends
	void deleteFriend(int user_1, int user_2);
	
	List<Friending> findFriendRequests(int id);
}
