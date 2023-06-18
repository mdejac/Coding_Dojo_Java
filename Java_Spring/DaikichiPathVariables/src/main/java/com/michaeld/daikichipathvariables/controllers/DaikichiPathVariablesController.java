package com.michaeld.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiPathVariablesController {
		@RequestMapping("")
		public String home() {
			return "Welcome!";
		}
		
		@RequestMapping("/today")
		public String today() {
			return "Today you will find luck in all your endeavors!";
		}
		
		@RequestMapping("/tomorrow")
		public String tomorrow() {
			return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
		}
		
		@RequestMapping("/travel/{destination}")
		public String travel(@PathVariable("destination") String destination) {
			return "Congratulations! You will soon travel to " + destination + "!";
		}
		
		@RequestMapping("/lotto/{number}")
		public String lotto(@PathVariable("number") String number) {
			String[] output = {"You will take a grand journey in the near future, but be wary of tempting offers.",
							   "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends."};
			return Integer.parseInt(number) % 2 == 0 ? output[0] : output[1];
		}
}
