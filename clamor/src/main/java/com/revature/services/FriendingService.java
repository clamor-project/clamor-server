package com.revature.services;

import java.util.List;

import com.revature.models.Friending;

public interface FriendingService {
	List<Friending> findAll();
	
	Friending findById(int id);
}
