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
	
	@Query("FROM user AS u WHERE u.id IN (SELECT user1 FROM friending WHERE user1 = :user_id)")
	public List<User> findUserFriends(@Param("user_id")int user_id);

}
