package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Friending;

public interface FriendingDao extends JpaRepository<Friending, Integer> {

}
