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

		return usergroupDao.findAll();
	}

	@Override
	public Usergroup findById(int id) {

		Optional<Usergroup> retVal = usergroupDao.findById(id);
		if(retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

	@Override
	public Usergroup save(Usergroup usergroup) {
		return usergroupDao.save(usergroup);
	}
	
	@Override
	public List<Usergroup> findByGroupId(int groupId) {
		return usergroupDao.findByGroupIdOrderById(groupId);
	}
	
	@Override
	public List<Usergroup> findByUserId(int userId) {
		return usergroupDao.findByUserId(userId);
	}
	
	@Override
	public List<Usergroup> findByUserIdAndGroupId(int userId, int groupId) {
		return usergroupDao.findByUserIdAndGroupId(userId, groupId);
	}

	@Override
	public void joinGroup(int userId, int groupId, int role) {

		usergroupDao.joinGroup(userId, groupId, role);
	}

	@Override
	public void updateUsergroupRole(int role, int userId, int groupId) {

		usergroupDao.updateUsergroupRole(role, userId, groupId);
	}
}
