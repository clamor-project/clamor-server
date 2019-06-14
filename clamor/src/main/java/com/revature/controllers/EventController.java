package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Event;
import com.revature.services.EventService;

@RestController
@RequestMapping("event")
public class EventController {

	private EventService eventService;

	@Autowired
	public EventController(EventService eventService) {
		super();
		this.eventService = eventService;
	}
	
	// this will likely not appear in the final code
	@GetMapping
	public List<Event> findAll(){
		return eventService.findAll();
	}
	
	@GetMapping("id/{id}")
	public Event findById(@PathVariable int id) {
		return eventService.findById(id);
	}
}
