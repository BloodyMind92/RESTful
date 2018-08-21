package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PersonContact;
import com.example.model.PersonContactDTO;
import com.example.model.PersonContactRepository;
import com.example.model.PersonRepository;

@RestController
public class PersonContactController {

	private static final String EMAIL = "email";
	private static final String NUMBER = "number";

	@Autowired
	PersonContactRepository contactRepository;

	@Autowired
	PersonRepository personRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/restful/addContact")
	@ResponseBody
	public void addContactToPerson(@RequestBody PersonContactDTO dto) {

		long personId = personRepository.findPersonByPesel(dto.getPesel()).getId();

		Map<String, String> contats = new HashMap<>();

		if (dto.getEmail() != null) {
			contats.put(EMAIL, dto.getEmail());
		}
		if (dto.getPhoneNumber() != null) {
			contats.put(NUMBER, dto.getPhoneNumber());
		}

		contats.entrySet().stream().forEach(c -> {
			if (contactRepository.findContactByDescription(c.getValue()) == null) {
				contactRepository.save(new PersonContact.Bulider().contactPeopleId(personId).contactKind(c.getKey())
						.contactDescription(c.getValue()).bulid());
			}
		});
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/restful/deleteContact")
	@ResponseBody
	@Transactional
	public void deleteContact(@RequestParam(name = "description") String description) {

		PersonContact contact = contactRepository.findContactByDescription(description);

		if (contact != null) {
			contactRepository.delete(contact);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/restful/updateContact")
	@ResponseBody
	public void updateContact(@RequestBody PersonContactDTO dto) {

		Map<String, String> old = new HashMap<>();
		Map<String, String> now = new HashMap<>();

		if (dto.getOldEmail() != null) {

			old.put(EMAIL, dto.getOldEmail());
			now.put(EMAIL, dto.getNewEmail());

		}
		if (dto.getOldNumber() != null) {

			old.put(NUMBER, dto.getOldNumber());
			now.put(NUMBER, dto.getNewNumber());

		}

		old.entrySet().stream().forEach(c -> {

			PersonContact contact = contactRepository.findContactByDescription(c.getValue());
			
			if(contact != null) {
				contact.setDescription(now.get(c.getKey()));
				contactRepository.save(contact);
			}
		});

	}

}
