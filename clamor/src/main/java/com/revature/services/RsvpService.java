package com.revature.services;

import java.util.List;

import com.revature.models.Rsvp;

public interface RsvpService {
	List<Rsvp> findAll();
	Rsvp findById(int id);
}
