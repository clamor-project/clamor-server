package com.revature.services;

import java.util.List;

import com.revature.models.Role;

public interface RoleService {

	List<Role> findAll();
	
	Role findById(int id);
	
	Role save(Role role);
	
	boolean deleteById(int id);
}
