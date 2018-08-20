package com.example.converters;

import org.springframework.stereotype.Component;

import com.example.model.Person;
import com.example.model.PersonDTO;

@Component
public class PersonConverter implements BaseConverter<Person, PersonDTO>{

	@Override
	public PersonDTO convert(Person from) {
		PersonDTO person = new PersonDTO();
		person.setName(from.getName());
		person.setLastName(from.getLastName());
		person.setSex(from.getSex());
		person.setBrithday(from.getBrithday());
		person.setPESEL(from.getPESEL());
		
		return person;
	}

}
