package com.revature.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Friending;
import com.revature.models.User;

public interface FriendingDao extends JpaRepository<Friending, Integer> {

	//to add friends and accept friends
	@Modifying
	@Query(value = "INSERT INTO clamor.friending(user_1, user_2) VALUES ( :user_1, :user_2)", nativeQuery = true)
	@Transactional
	void addFriend(@Param("user_1") int user_1, @Param("user_2") int user_2);
		
	//deleting friends
	@Modifying
	@Query(value = "DELETE FROM clamor.friending AS f WHERE (f.user_1 = :user_1 AND f.user_2 = :user_2) OR (f.user_2 = :user_1 AND f.user_1 = :user_2)", nativeQuery = true)
	@Transactional
	void deleteFriend(@Param("user_1") int user_1,@Param("user_2") int user_2);
	
	//find existing friends
	@Query(" FROM friending AS a LEFT JOIN friending AS b ON a.user1 = b.user2 WHERE a.user1 = b.user2 AND b.user1 = a.user2 AND a.user2.id = :id")
	public List<Friending> findUserFriends(@Param("id") int id);
		
	//see friend requests gotten
	@Modifying
	@Query(value = "SELECT * FROM clamor.friending WHERE user1.id = :id OR user2.id = :id EXCEPT (SELECT user2 AS user1, user1 AS user2 FROM friending WHERE user2.id = :id OR user1.id = :id)", nativeQuery = true)
	public List<Friending> findFriendRequests(@Param("id") int id);
	
}
