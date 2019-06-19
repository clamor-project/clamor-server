package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.GroupTag;
import com.revature.repositories.GroupTagDao;

@Service
public class GroupTagServiceImpl implements GroupTagService {

	private GroupTagDao groupTagDao;
	
	@Autowired
	public GroupTagServiceImpl(GroupTagDao groupTagDao) {
		super();
		this.groupTagDao = groupTagDao;
	}

	@Override
	public List<GroupTag> findAll() {

		return groupTagDao.findAll();
	}

	@Override
	public GroupTag findById(int id) {

		Optional<GroupTag> retVal = groupTagDao.findById(id);
		if (retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

	@Override
	public GroupTag save(GroupTag groupTag) {

		return groupTagDao.save(groupTag);
	}

	@Override
	public boolean deleteById(int id) {

		try {
			groupTagDao.deleteById(id);
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}
}
