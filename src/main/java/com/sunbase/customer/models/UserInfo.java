package com.sunbase.customer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserInfo { 
  // login me email and pass
//	2 btn, login and signup
	// login pe generate token api hit
	// will rcv 1 token, which i will have to pass in further api calls
	// signup pe add user api hit
	
	// size - 20, page - 0, on opening of the main list page
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; 
    private String name = ""; 
    private String email; 
    private String password; 
    private String roles = "admin";
	public UserInfo(int id, String name, String email, String password, String roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	public UserInfo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	} 
  
    
} 
