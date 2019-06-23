package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.DirectMessage;
import com.revature.repositories.DirectMessageDao;

@Service
public class DirectMessageServiceImpl implements DirectMessageService {

	private DirectMessageDao directMessageDao;
	
	@Autowired
	public DirectMessageServiceImpl(DirectMessageDao directMessageDao) {
		super();
		this.directMessageDao = directMessageDao;
	}

	@Override
	public List<DirectMessage> findAll() {

		return directMessageDao.findAll();
	}

	@Override
	public DirectMessage findById(int id) {

		Optional<DirectMessage> retVal = directMessageDao.findById(id);
		if (retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

	@Override
	public DirectMessage save(DirectMessage directMessage) {

		return directMessageDao.save(directMessage);
	}

	@Override
	public boolean deleteById(int id) {
		
		try {
			directMessageDao.deleteById(id);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}

	@Override
	public List<DirectMessage> findByConversation(int id1, int id2) {
		return directMessageDao.findByConversation(id1, id2);
	}
}
