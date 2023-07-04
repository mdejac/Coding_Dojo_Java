package com.michaeld.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.dojosandninjas.models.Dojo;
import com.michaeld.dojosandninjas.repositories.DojoRepo;

@Service
public class DojoService {
	@Autowired
	DojoRepo dojoRepo;
	
	public Dojo create(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public List<Dojo> getAll() {
		return dojoRepo.findAll();
	}
	
	public Dojo getById(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	
	public Dojo update(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public void delete(Long id) {
		dojoRepo.deleteById(id);
	}
}
