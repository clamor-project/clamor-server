package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Group;

public interface GroupDao extends JpaRepository<Group, Integer> {

	List<Group> findByName(String name);
	
	List<Group> findByNameLikeIgnoreCase(String name);
	
	List<Group> findByDescriptionLikeIgnoreCase(String description);
	
	List<Group> findByNameLikeIgnoreCaseOrDescriptionLikeIgnoreCase(String name, String description);
}
