package com.example.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NonNull
	@Size(min = 2, message="Za mało liter")
	private String name;
	
	@Column(name="lastname")
	private String lastName;
	
	private String sex;
	
	private Date brithday;
	
	@Column(name="pesel")
	private String pesel;
	
	public Person(Bulider bulider) {
		
		if(bulider == null) {
			return;
		}
		
		name = bulider.name;
		lastName = bulider.lastName;
		sex = bulider.sex;
		brithday = bulider.brithday;
		pesel = bulider.pesel;
	}
	
	protected Person() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	public void setPESEL(String pESEL) {
		pesel = pESEL;
	}
	
	public static class Bulider{
		
		private String name;
		private String lastName;
		private String sex;
		private Date brithday;
		private String pesel;
		
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
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(1918, 1, 1);
			
			if(brithday.after(new Date()) || brithday.before(calendar.getTime())){
				return null;
			}
			
			this.brithday = brithday;
			return this;
		}
		
		public Bulider PESELOfPerson(String PESEL) {
			this.pesel = PESEL;
			return this;
		}
		
		public Person bulid() {
			return new Person(this);
		}
		
	}
	
}
