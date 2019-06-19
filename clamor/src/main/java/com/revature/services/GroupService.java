package com.revature.services;

import java.util.List;

import com.revature.models.Group;

public interface GroupService {
	List<Group> findAll();
	
	Group findById(int id);
	
	List<Group> findByName(String name);
	
	Group save(Group group);
	
	List<Group> searchByName(String name);
	
	List<Group> searchByDescription(String description);
	
	List<Group> searchByNameOrDescription(String query);
	
	void deleteById(int groupId);
}
