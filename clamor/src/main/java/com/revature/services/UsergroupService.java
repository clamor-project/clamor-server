package com.revature.services;

import java.util.List;

import com.revature.models.Usergroup;

public interface UsergroupService {
	List<Usergroup> findAll();
	
	Usergroup findById(int id);
	
	Usergroup save(Usergroup usergroup);
	
	List<Usergroup> findByGroupId(int groupId);

	List<Usergroup> findByUserId(int userId);
	
	List<Usergroup> findByUserIdAndGroupId(int userId, int groupId);
	
	void joinGroup(int userId, int groupId, int role);
	
	void updateUsergroupRole(int role, int userId, int groupId);
}
