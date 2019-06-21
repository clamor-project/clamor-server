package com.revature.services;

import java.util.ArrayList;
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
	public void addFriend(int user_1, int user_2) {
		friendingDao.addFriend(user_1, user_2);
	}

	@Override
	public void deleteFriend(int user_1, int user_2) {
		friendingDao.deleteFriend(user_1, user_2);
	}

	@Override
	public List<Friending> findFriendRequests(int id) {
		
		List<Friending> potential = friendingDao.findByUser2Id(id);
		List<Friending> myFriending = friendingDao.findByUser1Id(id);
		List<Friending> theList = new ArrayList<>();
		for (Friending f : potential) {
			for (Friending m : myFriending) {
				if (f.getUser1() != m.getUser2() || f.getUser2() != m.getUser1()) {
					theList.add(f);
				}
			}
		}
		return theList;
	}
}
