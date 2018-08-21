package com.example.model;

import org.springframework.data.repository.CrudRepository;

public interface PersonContactRepository extends CrudRepository<PersonContact, Long>{

	PersonContact findContactByDescription(String description);
}
