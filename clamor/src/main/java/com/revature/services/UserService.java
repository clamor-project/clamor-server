package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {
	List<User> findAll();
	User findById(int id);
}
