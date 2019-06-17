package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Tag;

public interface TagDao extends JpaRepository<Tag, Integer> {

}
