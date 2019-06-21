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
	
	@Query("FROM user AS u WHERE u.id NOT IN (SELECT a.user1 FROM friending AS a LEFT JOIN friending AS b ON a.user1 = b.user2 WHERE a.user2.id = :id) AND u.id != :id")
	public List<User> findPotentialFriends(@Param("id") int id);
}