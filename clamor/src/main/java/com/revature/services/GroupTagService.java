package com.revature.services;

import java.util.List;

import com.revature.models.GroupTag;

public interface GroupTagService {

	List<GroupTag> findAll();
	
	GroupTag findById(int id);
	
	GroupTag save(GroupTag groupTag);
	
	boolean deleteById(int id);
}
