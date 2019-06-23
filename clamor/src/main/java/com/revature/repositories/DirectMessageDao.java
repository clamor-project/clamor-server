package com.revature.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.models.DirectMessage;

public interface DirectMessageDao extends JpaRepository<DirectMessage, Integer> {

	@Query("FROM DirectMessage AS dm WHERE dm.friends.user1.id = :id1 AND dm.friends.user2.id = :id2 OR (dm.friends.user1.id = :id2 AND dm.friends.user2.id = :id1) ORDER BY dm.id DESC")
	public List<DirectMessage> findByConversation(@Param("id1") int id1, @Param("id2") int id2);
}
