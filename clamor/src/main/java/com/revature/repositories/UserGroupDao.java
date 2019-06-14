package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.UserGroup;

public interface UserGroupDao extends JpaRepository<UserGroup, Integer> {

}
