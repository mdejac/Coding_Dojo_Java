package com.michaeld.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.dojosandninjas.models.Ninja;
import com.michaeld.dojosandninjas.repositories.NinjaRepo;
@Service
public class NinjaService {

	@Autowired
	NinjaRepo ninjaRepo;
	
	public Ninja create(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	public List<Ninja> getAll() {
		return ninjaRepo.findAll();
	}
	
	public Ninja getById(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
}
