package com.example.converters;

import com.example.beans.PersonContact;
import com.example.beans.PersonContactDTO;

public class PersonContactConverter implements BaseConverter<PersonContact, PersonContactDTO>{

	@Override
	public PersonContactDTO convert(PersonContact from) {
		
		PersonContactDTO dto = new PersonContactDTO();
		dto.setPeopleID(from.getPeopleID());
		dto.setKind(from.getKind());
		dto.setDescription(from.getDescription());
		
		return dto;
	}


}
