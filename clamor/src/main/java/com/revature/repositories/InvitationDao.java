package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Invitation;

public interface InvitationDao extends JpaRepository<Invitation, Integer> {

}
