package com.revature.services;

import java.util.List;

import com.revature.models.Mute;

public interface MuteService {

	List<Mute> findAll();
	
	Mute findById(int id);
	
	Mute save(Mute mute);
	
	boolean deleteById(int id);
}
