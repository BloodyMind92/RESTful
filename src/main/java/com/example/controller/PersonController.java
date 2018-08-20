package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.model.PersonDTO;
import com.example.model.PersonRepository;

@RestController
public class PersonController {
	
	@Autowired
	PersonRepository persons;
	
	@RequestMapping(method=RequestMethod.POST, value="/restful/addPerson")
	@ResponseBody
	public Person addNewPerson(@RequestBody PersonDTO person) {
		return new Person.Bulider().nameOfPerson(person.getName()).lastNameOfPerson(person.getLastName())
				.sexOfPerson(person.getSex()).brithdayOfPerson(person.getBrithday()).PESELOfPerson(person.getPESEL()).bulid();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/restful/allPersons")
	@ResponseBody
	public List<Person> getPersonsAll(){
		
		return (List<Person>) persons.findAll();
	}

}
