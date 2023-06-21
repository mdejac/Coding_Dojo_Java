package com.michaeld.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class APIController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String showDate(Model model) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMM d, y");
		String formattedDate = dateFormat.format(currentDate);
		model.addAttribute("date", formattedDate);
		return "showDate.jsp";
	}
	
	@RequestMapping("/time")
	public String showTime(Model model) {
		Date currentDate = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:m a");
		String formattedTime = timeFormat.format(currentDate);
		model.addAttribute("time", formattedTime);
		return "showTime.jsp";
	}
}
