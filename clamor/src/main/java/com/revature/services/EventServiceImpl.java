package com.revature.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Event;
import com.revature.repositories.EventDao;

@Service
public class EventServiceImpl implements EventService {

	private EventDao eventDao;
	
	@Autowired
	public EventServiceImpl(EventDao eventDao) {
		super();
		this.eventDao = eventDao;
	}

	@Override
	public List<Event> findAll() {
		// TODO Auto-generated method stub
		return eventDao.findAll();
	}

	@Override
	public Event findById(int id) {
		// TODO Auto-generated method stub
		Optional<Event> retVal = eventDao.findById(id);
		if(retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Event> findByGroupId(int groupId) {
		return eventDao.findByGroupId(groupId);
	}

	@Override
	public Event createEvent(int usergroupId, int groupId, String description, Date datePosted, Date dateOf,
			boolean live) {

		return eventDao.createEvent(usergroupId, groupId, description, datePosted, dateOf, live);
	}
}
