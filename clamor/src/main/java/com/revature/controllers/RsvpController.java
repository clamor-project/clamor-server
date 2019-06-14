package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Rsvp;
import com.revature.services.RsvpService;

@RestController
@RequestMapping("rsvp")
public class RsvpController {

	private RsvpService rsvpService;

	@Autowired
	public RsvpController(RsvpService rsvpService) {
		super();
		this.rsvpService = rsvpService;
	}
	
	@GetMapping
	public List<Rsvp> findAll() {
		return rsvpService.findAll();
	}
	
	@GetMapping("id/{id}")
	public Rsvp findById(@PathVariable int id) {
		return rsvpService.findById(id);
	}
}
