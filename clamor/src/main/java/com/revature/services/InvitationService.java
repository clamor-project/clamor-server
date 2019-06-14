package com.revature.services;

import java.util.List;

import com.revature.models.Invitation;

public interface InvitationService {
	List<Invitation> findAll();
	Invitation findById(int id);
}
