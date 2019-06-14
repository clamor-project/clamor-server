package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.Usergroup;

public interface UsergroupDao extends JpaRepository<Usergroup, Integer> {
}
