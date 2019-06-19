package com.revature.services;

import java.util.List;

import com.revature.models.Tag;

public interface TagService {

	List<Tag> findAll();
	
	Tag findById(int id);
	
	Tag save(Tag tag);
	
	boolean deleteById(int id);
}
