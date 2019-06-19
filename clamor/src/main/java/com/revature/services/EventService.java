package com.revature.services;

import java.util.Date;
import java.util.List;

import com.revature.models.Event;

public interface EventService {
	List<Event> findAll();
	
	Event findById(int id);
	
	List<Event> findByGroupId(int groupId);
	
	Event createEvent(int usergroupId, int groupId, String description, Date datePosted, Date dateOf, boolean live);
}
