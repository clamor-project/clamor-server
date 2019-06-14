package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.UserGroup;
import com.revature.repositories.UserGroupDao;

@Service
public class UserGroupServiceImpl implements UserGroupService {

	private UserGroupDao userGroupDao;
	
	@Autowired
	public UserGroupServiceImpl(UserGroupDao userGroupDao) {
		super();
		this.userGroupDao = userGroupDao;
	}

	@Override
	public List<UserGroup> findAll() {
		// TODO Auto-generated method stub
		return userGroupDao.findAll();
	}

	@Override
	public UserGroup findById(int id) {
		// TODO Auto-generated method stub
		Optional<UserGroup> retVal = userGroupDao.findById(id);
		if(retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

}
