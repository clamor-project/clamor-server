package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Role;
import com.revature.repositories.RoleDao;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	
	@Autowired
	public RoleServiceImpl(RoleDao roleDao) {
		super();
		this.roleDao = roleDao;
	}

	@Override
	public List<Role> findAll() {

		return roleDao.findAll();
	}

	@Override
	public Role findById(int id) {

		Optional<Role> retVal = roleDao.findById(id);
		if (retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

	@Override
	public Role save(Role role) {

		return roleDao.save(role);
	}

	@Override
	public boolean deleteById(int id) {

		try {
			roleDao.deleteById(id);
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
}
