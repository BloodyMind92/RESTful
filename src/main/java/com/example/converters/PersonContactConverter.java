package com.example.converters;

import com.example.model.PersonContact;
import com.example.model.PersonContactDTO;

public class PersonContactConverter implements BaseConverter<PersonContact, PersonContactDTO>{

	@Override
	public PersonContactDTO convert(PersonContact from) {
		
		PersonContactDTO dto = new PersonContactDTO();
		dto.setEmail(from.getDescription());
		dto.setPhoneNumber(from.getDescription());
		
		return dto;
	}


}
