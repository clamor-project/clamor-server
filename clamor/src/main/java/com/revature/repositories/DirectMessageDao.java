package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.DirectMessage;

public interface DirectMessageDao extends JpaRepository<DirectMessage, Integer> {

}
