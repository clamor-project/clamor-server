package com.revature.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.revature.models.Friending;

public interface FriendingService {
	List<Friending> findAll();
	
	Friending findById(int id);
	
	//to add friends and accept friends
	void addFriend(int user_1, int user_2);
	
	//deleting friends
	void deleteFriend(int user_1, int user_2);
	
	//to find existing friends
	public List<Friending> findUserFriends(int id);
	
	//to find existing friend requests
	public List<Friending> findFriendRequests( int id);

}
