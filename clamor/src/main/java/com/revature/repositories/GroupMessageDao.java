package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.GroupMessage;

public interface GroupMessageDao extends JpaRepository<GroupMessage, Integer> {

}
