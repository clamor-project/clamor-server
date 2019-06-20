package com.revature.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.revature.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	public List<User> findByUsernameAndPassword(String username, String password);
	
	public List<User> findByUsernameOrEmail(String username, String email);
	
	public User findByUsername(String username);
	
	//find existing friends
	@Query("FROM user AS u WHERE u.id IN (SELECT a.user1 FROM friending AS a LEFT JOIN friending AS b ON a.user1 = b.user2 WHERE a.user1 = b.user2 AND b.user1 = a.user2 AND a.user2.id = :id)")
	public List<User> findUserFriends(@Param("id") int id);
	
	//see friend requests gotten
	@Query("FROM user AS u WHERE u.id IN (SELECT a.user1 FROM friending AS a LEFT JOIN friending AS b ON a.user1 = b.user2 WHERE a.user1 = b.user2 AND NOT b.user1 = a.user2 AND a.user2.id = :id)")
	public List<User> findFriendRequests(@Param("id") int id);

	@Query("FROM user AS u WHERE u.id NOT IN (SELECT a.user1 FROM friending AS a LEFT JOIN friending AS b ON a.user1 = b.user2 WHERE a.user2.id = :id) AND u.id != :id")
	public List<User> findPotentialFriends(@Param("id") int id);
}