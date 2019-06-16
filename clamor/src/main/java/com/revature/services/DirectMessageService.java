package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.models.DirectMessage;

public interface DirectMessageService {

	List<DirectMessage> findAll();
	
	DirectMessage findById(int id);
	
	DirectMessage save(DirectMessage directMessage);
	
	boolean deleteById(int id);
}
