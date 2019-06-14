package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Usergroup;
import com.revature.repositories.UsergroupDao;

@Service
public class UsergroupServiceImpl implements UsergroupService {

	private UsergroupDao usergroupDao;
	
	@Autowired
	public UsergroupServiceImpl(UsergroupDao userGroupDao) {
		super();
		this.usergroupDao = userGroupDao;
	}

	@Override
	public List<Usergroup> findAll() {
		// TODO Auto-generated method stub
		return usergroupDao.findAll();
	}

	@Override
	public Usergroup findById(int id) {
		// TODO Auto-generated method stub
		Optional<Usergroup> retVal = usergroupDao.findById(id);
		if(retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

}
