package com.example.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	
	List<Person> findByNameAndLastName(String name, String lastName);
	
	void deletePersonByPesel(String pesel);
	
	Person findPersonByPesel(String pesel);
	
	Person findPersonByNameAndLastNameAndPesel(String name, String lastName, String pesel);
	
	@Query(value = "SELECT p FROM person p WHERE brithday >= :dateBefore AND brithday <= :dateAfter")
	List<Person> findPeopleByBirthDateBetween(@Param("dateBefore") Date dateBefore,@Param("dateAfter") Date dateAfter);
	
	@Query(value = "SELECT p FROM person p INNER JOIN personcontact pc on p.id = pc.personId WHERE pc.description like %:email%")
	List<Person> findPeopleByEmail(@Param("email") String email);
}
