package com.revature.dtos;

import java.util.Date;

import com.revature.models.User;

public class UserDTO {

	private int id;
	private String username;
	private String email;
	private Date dateOfBirth;
	
	
	
	public UserDTO(User u) {
		super();
		this.id = u.getId();
		this.username = u.getUsername();
		this.email = u.getEmail();
		this.dateOfBirth = u.getDateOfBirth();
	}
	
	// use this constructor if you want to hide email and dateOfBirth
	public UserDTO(User u, boolean b) {
		super();
		this.id = u.getId();
		this.username = u.getUsername();
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
