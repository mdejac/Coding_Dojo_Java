package com.michaeld.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.relationships.models.Person;
import com.michaeld.relationships.repositories.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;
	
	public Person create(Person p) {
		return personRepo.save(p);
	}
	
	public List<Person> getAll() {
		return personRepo.findAll();
	}
	
	public Person getById(Long id) {
		return personRepo.findById(id).orElse(null);
	}
}
