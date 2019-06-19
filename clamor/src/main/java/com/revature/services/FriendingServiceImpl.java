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
	public Friending addFriend(int user_1, int user_2) {
		Friending retFriend = friendingDao.addFriend(user_1, user_2);
		if(Optional.of(retFriend).isPresent()) {
			return retFriend;
		} else {
			return null;
		}
	}

	@Override
	public Friending deleteFriend(int user_1, int user_2) {
		Friending retFriend = friendingDao.deleteFriend(user_1, user_2);
		if(Optional.of(retFriend).isPresent()) {
			return retFriend;
		} else {
			return null;
		}
	}

}
