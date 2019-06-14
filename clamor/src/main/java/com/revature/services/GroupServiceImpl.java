package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Group;
import com.revature.repositories.GroupDao;

@Service
public class GroupServiceImpl implements GroupService {

	private GroupDao groupDao;
	
	@Autowired
	public GroupServiceImpl(GroupDao groupDao) {
		super();
		this.groupDao = groupDao;
	}

	@Override
	public List<Group> findAll() {
		// TODO Auto-generated method stub
		return groupDao.findAll();
	}

	@Override
	public Group findById(int id) {
		// TODO Auto-generated method stub
		Optional<Group> retGroup = groupDao.findById(id);
		if(retGroup.isPresent()) {
			return retGroup.get();
		} else {
			return null;
		}
	}

}
