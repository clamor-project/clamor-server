package com.revature.services;

import java.util.List;

import com.revature.models.UserGroup;

public interface UserGroupService {
	List<UserGroup> findAll();
	UserGroup findById(int id);
}
