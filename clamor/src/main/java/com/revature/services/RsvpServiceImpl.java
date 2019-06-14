package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Rsvp;
import com.revature.repositories.RsvpDao;

@Service
public class RsvpServiceImpl implements RsvpService {

	private RsvpDao rsvpDao;
	
	@Autowired
	public RsvpServiceImpl(RsvpDao rsvpDao) {
		super();
		this.rsvpDao = rsvpDao;
	}

	@Override
	public List<Rsvp> findAll() {
		// TODO Auto-generated method stub
		return rsvpDao.findAll();
	}

	@Override
	public Rsvp findById(int id) {
		Optional<Rsvp> retVal = rsvpDao.findById(id);
		if(retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

}
