package com.revature.services;

import java.util.List;

import com.revature.models.GroupMessage;

public interface GroupMessageService {
	List<GroupMessage> findAll();
	GroupMessage findById(int id);
}
