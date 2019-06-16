package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
