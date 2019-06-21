package com.revature.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserDao;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		Optional<User> retUser = userDao.findById(id);
		if(retUser.isPresent()) {
			return retUser.get();
		} else {
			return null;
		}
	}

	@Override
	public User getLogin(String username, String password) {

		List<User> userList = userDao.findByUsernameAndPassword(username, password);
		User retUser;
		
		if (userList.size() == 1) {
			retUser = userList.get(0);
		} else {
			retUser = new User(0, "", "", "", new Date(0));
		}
		
		return retUser;
	}
	
	public User save(String username, String password, String email, Date dob) {
			User userToSave = new User(0, username, password, email, dob);
			List<User> existingUsers = userDao.findByUsernameOrEmail(username, email);
			if(existingUsers.isEmpty()) {
				return userDao.save(userToSave);
			} else {
				return userToSave;
			}
		
	}

	@Override
	public User getUser(String username) {
		User retUser = userDao.findByUsername(username);
		
		//so Can still make it temporarily a optional just to check if it exists
		if(Optional.of(retUser).isPresent()) { 
			return retUser;
		} else {
			return null;
		}
	}

	@Override
	public List<User> getPotentialFriends(int id) {
		return userDao.findPotentialFriends(id);
	}

	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}

}
