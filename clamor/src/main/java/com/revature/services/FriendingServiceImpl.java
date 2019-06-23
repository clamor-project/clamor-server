package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Friending;
import com.revature.models.User;
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
		List<Friending> findingRequest = friendingDao.findAll();
		boolean flag = false;
		for(int x = 0; x < findingRequest.size(); x++) {
			if(findingRequest.get(x).getUser1().getId() == user_1 && findingRequest.get(x).getUser2().getId() == user_2) {
				flag = true;
			}
		}
		
		if(!flag) {
			friendingDao.addFriend(user_1, user_2);
		}
	}

	@Override
	public void deleteFriend(int user_1, int user_2) {
		friendingDao.deleteFriend(user_1, user_2);
	}

	@Override
	public List<Friending> findUserFriends(int id) {
		List<Friending> retUser = friendingDao.findUserFriends(id);
		
		for(int x = 0; x < retUser.size(); x++) {
			if(!Optional.of(retUser.get(x)).isPresent()) {
				retUser.remove(x);
			}
		}
		
		return retUser;
	}

	public List<Friending> findFriendRequests(int id) {
		
		List<Friending> potential = friendingDao.findByUser2Id(id);
		List<Friending> myFriending = friendingDao.findByUser1Id(id);
		List<Friending> theList = new ArrayList<>();
		for (Friending f : potential) {
			boolean add = true;
			for (Friending m : myFriending) {
				if ((f.getUser1() == m.getUser2() && f.getUser2() == m.getUser1())) {
					add = false;
				}
			}
			if(add) {
				theList.add(f);
			}
		}
		return theList;
	}
}
