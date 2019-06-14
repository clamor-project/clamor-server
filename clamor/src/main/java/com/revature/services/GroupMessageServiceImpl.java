package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.GroupMessage;
import com.revature.repositories.GroupMessageDao;

@Service
public class GroupMessageServiceImpl implements GroupMessageService {

	private GroupMessageDao groupMessageDao;
	
	@Autowired
	public GroupMessageServiceImpl(GroupMessageDao groupMessageDao) {
		super();
		this.groupMessageDao = groupMessageDao;
	}

	@Override
	public List<GroupMessage> findAll() {
		// TODO Auto-generated method stub
		return groupMessageDao.findAll();
	}

	@Override
	public GroupMessage findById(int id) {
		// TODO Auto-generated method stub
		Optional<GroupMessage> retVal = groupMessageDao.findById(id);
		if(retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

}
