package com.revature.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.models.Event;

public interface EventDao extends JpaRepository<Event, Integer> {

	List<Event> findByGroupIdId(int groupId);
	
	@Modifying
	@Query(value = "INSERT INTO clamor.event (creator, group_id, title, description, date_posted, date_of, live) VALUES (:usergroupId, :groupId, :title, :description, :datePosted, :dateOf, :live)", nativeQuery = true)
	@Transactional
	void createEvent(@Param("usergroupId") int usergroupId, @Param("groupId") int groupId, @Param("title") String title, @Param("description") String description, @Param("datePosted") Date datePosted, @Param("dateOf") Date dateOf, @Param("live") boolean live);
}
