package com.contacts.model;

import java.util.Calendar;

public class Contact{
	
	private Long id;
	private String name;
	private String email;
	private String address;
	private Calendar birthdate;
	
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	
	public Calendar getBirthdate(){
		return birthdate;
	}
	public void setBirthdate(Calendar birthdate){
		this.birthdate = birthdate;
	}
	
}