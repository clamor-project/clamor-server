package com.revature.services;

import java.util.Date;
import java.util.List;

import com.revature.models.Event;

public interface EventService {
	List<Event> findAll();
	
	Event findById(int id);
	
	List<Event> findByGroupId(int groupId);
	
	void createEvent(int usergroupId, int groupId, String title, String description, Date datePosted, Date dateOf, boolean live);
	
	Event save(Event event);
	
	boolean deleteById(int id);
}
