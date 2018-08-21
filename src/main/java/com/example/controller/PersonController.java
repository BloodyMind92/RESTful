package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.model.PersonDTO;
import com.example.model.PersonRepository;

@RestController
public class PersonController {

	@Autowired
	PersonRepository persons;

	@RequestMapping(method = RequestMethod.POST, value = "/restful/addPerson")
	@ResponseBody
	public String addNewPerson(@Valid @RequestBody PersonDTO dto) {

		Person person = new Person.Bulider().nameOfPerson(dto.getName()).lastNameOfPerson(dto.getLastName())
				.sexOfPerson(dto.getSex()).brithdayOfPerson(dto.getBrithday()).PESELOfPerson(dto.getPESEL()).bulid();

		if (persons.findPersonByPesel(person.getPESEL()) == null) {
			persons.save(person);
			return "Dodano osobe";
		} else {
			return "Osoba z danym nr PESEL już istnieje";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/restful/allPersons")
	@ResponseBody
	public List<Person> getPersonsAll() {
		return (List<Person>) persons.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/restful/deletePerson")
	@ResponseBody
	@Transactional
	public String deletePerson(@RequestParam(name = "pesel") String pesel) {

		if (persons.findPersonByPesel(pesel) != null) {
			persons.deletePersonByPesel(pesel);
			return "usunięto osobę";
		}
		else {
			return "brak danych";
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/restful/updatePerson")
	@ResponseBody
	@Transactional
	public String updatePerson(@RequestBody PersonDTO dto) {
		
		 Person person = persons.findPersonByPesel(dto.getPESEL());
		 
		 if(person != null) {
			 
			 person.setBrithday(dto.getBrithday());
			 person.setName(dto.getName());
			 person.setLastName(dto.getLastName());
			 person.setSex(dto.getSex());
			 
			 persons.save(person);
			 return "Zaktualizowano dane";
		 }
		 else {
			 return "Brak danych";
		 }
		 
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/restful/findPeopleByBirthDateBetween")
	@ResponseBody
	public List<Person> findPeopleByBirthDateBetween(@RequestParam(name="dateBefore") String dateBefore, @RequestParam(name="dateAfter") String dateAfter) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		
		return persons.findPeopleByBirthDateBetween(sdf.parse(dateBefore), sdf.parse(dateAfter));
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/restful/findPeopleByEmail")
	@ResponseBody
	public List<Person> findPeopleByEmail(@RequestParam(name="email") String email){
		
		return persons.findPeopleByEmail(email);
	}

}
