package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Invitation;
import com.revature.services.InvitationService;

@RestController
@RequestMapping("invitation")
public class InvitationController {

	private InvitationService invitationService;

	@Autowired
	public InvitationController(InvitationService invitationService) {
		super();
		this.invitationService = invitationService;
	}
	
	// dev only
	@GetMapping
	public List<Invitation> findAll(){
		return invitationService.findAll();
	}
	
	@GetMapping("id/{id}")
	public Invitation findById(@PathVariable int id) {
		return invitationService.findById(id);
	}
}
