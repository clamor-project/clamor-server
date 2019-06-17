package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Mute;
import com.revature.repositories.MuteDao;

@Service
public class MuteServiceImpl implements MuteService {

	private MuteDao muteDao;
	
	@Autowired
	public MuteServiceImpl(MuteDao muteDao) {
		super();
		this.muteDao = muteDao;
	}

	@Override
	public List<Mute> findAll() {

		return muteDao.findAll();
	}

	@Override
	public Mute findById(int id) {

		Optional<Mute> retVal = muteDao.findById(id);
		if (retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

	@Override
	public Mute save(Mute mute) {

		return muteDao.save(mute);
	}

	@Override
	public boolean deleteById(int id) {

		try {
			muteDao.deleteById(id);
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}
}
