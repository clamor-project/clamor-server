package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Friending;
import com.revature.repositories.FriendingDao;

@Service
public class FriendingServiceImpl implements FriendingService {

	private FriendingDao friendingDao;
	
	@Autowired
	public FriendingServiceImpl(FriendingDao friendingDao) {
		super();
		this.friendingDao = friendingDao;
	}

	@Override
	public List<Friending> findAll() {
		// TODO Auto-generated method stub
		return friendingDao.findAll();
	}

	@Override
	public Friending findById(int id) {
		// TODO Auto-generated method stub
		Optional<Friending> retVal = friendingDao.findById(id);
		if(retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Friending> findUserFriends(int id) {
		// TODO Auto-generated method stub
		List<Friending> retList = friendingDao.findUserFriends(id);
		
		for(int x = 0; x < retList.size(); x++) {
			if(Optional.of(retList.get(x)).isPresent()) {
				
			} else {
				Friending temp = new Friending();
				retList.remove(x);
				retList.add(x, temp);
			}
		}
		
		return retList;
	}

}
