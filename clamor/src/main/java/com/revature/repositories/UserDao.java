package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	public List<User> findByUsernameAndPassword(String username, String password);
	
	public User findByUsername(String username);
}
