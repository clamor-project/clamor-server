package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Group;

public interface GroupDao extends JpaRepository<Group, Integer> {

}
