package com.revature.services;

import java.util.List;

import com.revature.models.Usergroup;

public interface UsergroupService {
	List<Usergroup> findAll();
	Usergroup findById(int id);
}
