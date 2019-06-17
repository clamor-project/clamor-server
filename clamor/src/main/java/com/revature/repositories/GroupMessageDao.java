package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.GroupMessage;

public interface GroupMessageDao extends JpaRepository<GroupMessage, Integer> {

//	@Query("FROM GroupMessage AS gm INNER JOIN Usergroup AS ug ON gm.author = ug.id WHERE ug.group_id = :id")
//	List<GroupMessage> findByGroupId(int id);
}
