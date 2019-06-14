package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Invitation;
import com.revature.repositories.InvitationDao;

@Service
public class InvitationServiceImpl implements InvitationService {

	private InvitationDao invitationDao;
	
	@Autowired
	public InvitationServiceImpl(InvitationDao invitationDao) {
		super();
		this.invitationDao = invitationDao;
	}
	
	@Override
	public List<Invitation> findAll() {
		// TODO Auto-generated method stub
		return invitationDao.findAll();
	}




	@Override
	public Invitation findById(int id) {
		// TODO Auto-generated method stub
		Optional<Invitation> retVal = invitationDao.findById(id);
		if(retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

}
