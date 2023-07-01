package com.michaeld.relationships.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.relationships.models.License;
import com.michaeld.relationships.services.LicenseService;
import com.michaeld.relationships.services.PersonService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/licenses")
public class LicenseController {
	
	@Autowired
	private LicenseService licenseService;
	@Autowired
	private PersonService personService;
	
	@GetMapping("/new")
	public String createLicense(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("allPersons", personService.getAll());
		return "licenseCreate.jsp";
	}
	
	@PostMapping("/create")
	public String createLicenseSubmit(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allPersons", personService.getAll());
			return "licenseCreate.jsp";
		}
		licenseService.create(license);
		return "redirect:/";
	}
}
