package com.michaeld.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	@RequestMapping("/")
	public String home(@RequestParam(value="first_name", required = false) String firstName,
					   @RequestParam(value="last_name", required = false) String lastName,
					   @RequestParam(value="times", required = false) String times) {
		String output = "";
		String returnString = "";
		int repeatTimes = times == null ? 1 : Integer.parseInt(times);

		if (firstName == null) {
			output =  "Hello human!";
		} else {
			output = "Hello " + firstName + (lastName == null ? " " : " " + lastName) + "! ";
		}
		
		for (int i = 0; i < repeatTimes; i++) {
			returnString += output; 
		}
		
		return returnString;
	}
}
