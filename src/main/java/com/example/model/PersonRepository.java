package com.example.model;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	
	List<Person> findByNameAndLastName(String name, String lastName);
	
	void deletePersonByPesel(String pesel);
	
	Person findPersonByPesel(String pesel);
	
	Person findPersonByNameAndLastNameAndPesel(String name, String lastName, String pesel);
}
