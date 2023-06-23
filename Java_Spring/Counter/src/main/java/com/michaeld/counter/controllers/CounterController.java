package com.michaeld.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpSession session) {
		if (session.getAttribute("visitCount") == null) {
			session.setAttribute("visitCount", 0);
		}
		session.setAttribute("visitCount", (Integer)session.getAttribute("visitCount")+1);
		
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counterDisplay() {
		return "counterDisplay.jsp";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String resetCounter(HttpSession session) {
		session.setAttribute("visitCount", 0);
		return "index.jsp";
	}
	
}
