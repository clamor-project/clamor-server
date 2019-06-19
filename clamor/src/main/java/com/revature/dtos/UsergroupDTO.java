package com.revature.dtos;

import java.util.Date;

import com.revature.models.Group;
import com.revature.models.Role;
import com.revature.models.Usergroup;

public class UsergroupDTO {
	
	private int id;
	private UserDTO user;
	private Group group;
	private Date joinedDate;
	private Role role;

	
	public UsergroupDTO(Usergroup usergroup) {
		super();
		this.id = usergroup.getId();
		this.user = new UserDTO(usergroup.getUser());
		this.group = usergroup.getGroup();
		this.joinedDate = usergroup.getJoinedDate();
		this.role = usergroup.getRole();
	}

	public UsergroupDTO(Usergroup usergroup, boolean b) {
		super();
		this.id = usergroup.getId();
		this.user = new UserDTO(usergroup.getUser(), b);
		this.group = usergroup.getGroup();
		this.joinedDate = usergroup.getJoinedDate();
		this.role = usergroup.getRole();
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}


	public Date getJoinedDate() {
		return joinedDate;
	}


	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public UsergroupDTO() {
		// TODO Auto-generated constructor stub
	}

}
