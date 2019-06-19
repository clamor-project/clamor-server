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
	
	public User findByUsername(String username);
	
	@Query("FROM user AS u WHERE u.id IN (SELECT a.user2 FROM friending AS a LEFT JOIN friending AS b ON a.user1 = b.user2 WHERE a.user1.id = :id)")
	public List<User> findUserFriends(@Param("id") int id);

}

//For friend requests
//"FROM user AS u WHERE u.id IN (SELECT user1 FROM friending WHERE user1 = :user_id)"