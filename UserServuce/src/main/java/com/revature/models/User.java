package com.revature.models;


public class User {

	private int id;
	private String user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String user) {
		super();
		this.id = id;
		this.user = user;
	}
	


}
