package com.revature.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Friending;

public interface FriendingDao extends JpaRepository<Friending, Integer> {

	//to add friends and accept friends
	@Modifying
	@Query(value = "INSERT INTO friending(user1, user2) VALUES ( :user_1, :user_2)", nativeQuery = true)
	@Transactional
	Friending addFriend(@Param("user_1") int user_1, @Param("user_2") int user_2);
		
	//deleting friends
	@Modifying
	@Query(value = "DELETE FROM friending AS f WHERE (f.user1 = :user_1 AND f.user2 = :user_2) AND (f.user2 = :user_1 AND f.user1 = :user_2)", nativeQuery = true)
	@Transactional
	Friending deleteFriend(@Param("user_1") int user_1,@Param("user_2") int user_2);
}
