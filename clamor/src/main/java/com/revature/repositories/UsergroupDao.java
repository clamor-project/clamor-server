package com.revature.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.models.Usergroup;

public interface UsergroupDao extends JpaRepository<Usergroup, Integer> {

	List<Usergroup> findByGroupIdOrderById(int groupId);
	
	List<Usergroup> findByUserId(int userId);
	
	List<Usergroup> findByUserIdAndGroupId(int userId, int groupId);
	
	@Modifying
	@Query(value = "INSERT INTO clamor.user_group (user_id, group_id, role) VALUES (:userId, :groupId, :role)", nativeQuery = true)
	@Transactional
	void joinGroup(@Param("userId") int userId, @Param("groupId") int groupId, @Param("role") int role);
	
	@Modifying
	@Query(value = "UPDATE clamor.user_group SET role = :role WHERE user_id = :userId AND group_id = :groupId", nativeQuery = true)
	@Transactional
	void updateUsergroupRole(@Param("role") int role, @Param("userId") int userId, @Param("groupId") int groupId);
	
	
}
