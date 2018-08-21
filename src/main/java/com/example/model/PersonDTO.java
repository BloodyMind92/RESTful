package com.example.model;

import java.util.Date;

public class PersonDTO {
	
	private int id;
	private String name;
	private String lastName;
	private String sex;
	private Date brithday;
	private String pesel;
	
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	public String getPESEL() {
		return pesel;
	}
	public void setPESEL(String pesel) {
		this.pesel = pesel;
	}
	
	
}
