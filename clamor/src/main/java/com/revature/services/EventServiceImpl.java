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
		return eventDao.findByGroupIdId(groupId);
	}

	@Override
	public void createEvent(int usergroupId, int groupId, String title, String description, Date datePosted, Date dateOf,
			boolean live) {

		eventDao.createEvent(usergroupId, groupId, title, description, datePosted, dateOf, live);
	}
	
	@Override
	public Event save(Event event) {
		return eventDao.save(event);
	}
	
	@Override
	public boolean deleteById(int id) {
		
		try {
			eventDao.deleteById(id);
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
}
