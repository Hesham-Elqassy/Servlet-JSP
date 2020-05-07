package com.entity;

public class User  {
	
	//data members
	
	private int id;
	private String username, password,adminstatus;
	
	
	public User() {
		super();
	}
	
	
	public User(int id, String username, String password, String adminstatus) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.adminstatus = adminstatus;
	}


	//Setters & Getters Methods
	public int getId() {
		return id;
	}
	public String getAdminstatus() {
		return adminstatus;
	}
	public void setAdminstatus(String adminstatus) {
		this.adminstatus = adminstatus;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	//To String() Method
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", adminstatus="
				+ adminstatus + "]";
	}


	
	
	
	

}
