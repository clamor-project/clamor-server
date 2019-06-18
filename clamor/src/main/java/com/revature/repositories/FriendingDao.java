package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.Friending;

public interface FriendingDao extends JpaRepository<Friending, Integer> {
	
	@Query("FROM friend where user_1 = :id")
	List<Friending> findUserFriends(int id);

}
