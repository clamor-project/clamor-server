package com.revature.services;

import java.util.List;

import com.revature.models.GroupMessage;

public interface GroupMessageService {
	
	List<GroupMessage> findAll();
	
	GroupMessage findById(int id);
	
	GroupMessage save(GroupMessage groupMessage);
	
	boolean deleteById(int id);
	
//	List<GroupMessage> findByGroupId(int id);
}
