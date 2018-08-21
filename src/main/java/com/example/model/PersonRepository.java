package com.example.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	
	List<Person> findByNameAndLastName(String name, String lastName);
}
