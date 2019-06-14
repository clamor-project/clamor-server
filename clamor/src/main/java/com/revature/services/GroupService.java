package com.revature.services;

import java.util.List;

import com.revature.models.Group;

public interface GroupService {
	List<Group> findAll();
	Group findById(int id);
}
