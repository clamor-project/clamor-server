package com.revature.services;

import java.util.List;

import com.revature.models.Usergroup;

public interface UsergroupService {
	List<Usergroup> findAll();
	
	Usergroup findById(int id);
	
	Usergroup save(Usergroup usergroup);
	
	List<Usergroup> findByGroupId(int groupId);

	List<Usergroup> findByUserId(int userId);
	
	void joinGroup(int userId, int groupId, int role);
	
	void updateUsergroupRole(int userId, int groupId, int role);
}
