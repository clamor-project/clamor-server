package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Tag;
import com.revature.repositories.TagDao;

@Service
public class TagServiceImpl implements TagService {
	
	private TagDao tagDao;
	
	@Autowired
	public TagServiceImpl(TagDao tagDao) {
		super();
		this.tagDao = tagDao;
	}

	@Override
	public List<Tag> findAll() {

		return tagDao.findAll();
	}

	@Override
	public Tag findById(int id) {

		Optional<Tag> retVal = tagDao.findById(id);
		if (retVal.isPresent()) {
			return retVal.get();
		} else {
			return null;
		}
	}

	@Override
	public Tag save(Tag tag) {

		return tagDao.save(tag);
	}

	@Override
	public boolean deleteById(int id) {

		try {
			tagDao.deleteById(id);
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}

}
