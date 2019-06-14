package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Rsvp;

public interface RsvpDao extends JpaRepository<Rsvp, Integer> {

}
