package com.revature.services;

import java.util.List;

import com.revature.models.Event;

public interface EventService {
	List<Event> findAll();
	Event findById(int id);
}
