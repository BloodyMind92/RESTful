package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.beans.Person;
import com.example.beans.PersonDTO;

@Controller
public class PersonController {
	
	@RequestMapping(method=RequestMethod.POST, value="/restful/addPerson")
	@ResponseBody
	public Person addNewPerson(@RequestBody PersonDTO person) {
		return new Person.Bulider().nameOfPerson(person.getName()).lastNameOfPerson(person.getLastName())
				.sexOfPerson(person.getSex()).brithdayOfPerson(person.getBrithday()).PESELOfPerson(person.getPESEL()).bulid();
	}

}
