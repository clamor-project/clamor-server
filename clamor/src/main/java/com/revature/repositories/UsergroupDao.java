package com.revature.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.models.Usergroup;

public interface UsergroupDao extends JpaRepository<Usergroup, Integer> {

	List<Usergroup> findByGroupId(int groupId);
	
	List<Usergroup> findByUserId(int userId);
	
	@Modifying
	@Query(value = "INSERT INTO clamor.user_group (user_id, group_id, role) VALUES (:userId, :groupId, :role);", nativeQuery = true)
	@Transactional
	void joinGroup(@Param("userId") int userId,@Param("groupId") int groupId,@Param("role") int role);
}
