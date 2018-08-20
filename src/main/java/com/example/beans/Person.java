package com.example.beans;

import java.sql.Date;

public class Person {

	private String name;
	private String lastName;
	private String sex;
	private Date brithday;
	private long PESEL;
	
	private Person(Bulider bulider) {
		
		if(bulider == null) {
			return;
		}
		
		name = bulider.name;
		lastName = bulider.lastName;
		sex = bulider.sex;
		brithday = bulider.brithday;
		PESEL = bulider.PESEL;
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
	public long getPESEL() {
		return PESEL;
	}
	public void setPESEL(long pESEL) {
		PESEL = pESEL;
	}
	
	public static class Bulider{
		
		private String name;
		private String lastName;
		private String sex;
		private Date brithday;
		private long PESEL;
		
		public Bulider nameOfPerson(String name) {
			this.name = name;
			return this;
		}

		public Bulider lastNameOfPerson(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public Bulider sexOfPerson(String sex) {
			this.sex = sex;
			return this;
		}
		
		public Bulider brithdayOfPerson(Date brithday) {
			this.brithday = brithday;
			return this;
		}
		
		public Bulider PESELOfPerson(long PESEL) {
			this.PESEL = PESEL;
			return this;
		}
		
		public Person bulid() {
			return new Person(this);
		}
		
	}
	
}
