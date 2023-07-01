package com.michaeld.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.relationships.models.License;
import com.michaeld.relationships.repositories.LicenseRepo;

@Service
public class LicenseService {
	
	@Autowired
	private LicenseRepo licenseRepo;
	
	public License create(License l) {
		return licenseRepo.save(l);
	}
	
	public List<License> getAll() {
		return licenseRepo.findAll();
	}
	
	public License getById(Long id) {
		return licenseRepo.findById(id).orElse(null);
	}
}
