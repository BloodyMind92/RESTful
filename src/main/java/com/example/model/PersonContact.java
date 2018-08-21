package com.example.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name ="personcontact")
@Table(name="personcontact")
public class PersonContact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="personid")
	@Basic
	private long personId;
	private String kind;
	private String description;
	
	public PersonContact() {
	}
	
	public PersonContact(Bulider bulider) {
		
		if(bulider == null) {
			return;
		}
		
		personId = bulider.personId;
		kind = bulider.kind;
		description = bulider.description;
		
	}
	
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long peopleID) {
		this.personId = peopleID;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public static class Bulider{
		
		private long personId;
		private String kind;
		private String description;
		
		public Bulider contactPeopleId(long personId) {
			this.personId = personId;
			return this;
		}
		
		public Bulider contactKind(String kind) {
			this.kind = kind;
			return this;
		}
		
		public Bulider contactDescription(String description) {
			this.description = description;
			return this;
		}
		
		public PersonContact bulid() {
			return new PersonContact(this);
		}
		
	}
}
