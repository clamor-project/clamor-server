package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Mute;

public interface MuteDao extends JpaRepository<Mute, Integer> {

}
