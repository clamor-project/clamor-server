package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Usergroup;

public interface UsergroupDao extends JpaRepository<Usergroup, Integer> {

	List<Usergroup> findByGroupId(int groupId);
}
