package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.GroupMessage;

public interface GroupMessageDao extends JpaRepository<GroupMessage, Integer> {

	@Query("FROM GroupMessage AS gm INNER JOIN Usergroup AS ug ON gm.author = ug.id INNER JOIN Group AS g ON ug.group = g.id WHERE g.id = :groupId ORDER BY gm.id DESC")
	List<GroupMessage> findByGroupId(int groupId);
}
