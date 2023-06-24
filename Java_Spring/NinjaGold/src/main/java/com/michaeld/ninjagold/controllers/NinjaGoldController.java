package com.michaeld.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ninjaGold")
public class NinjaGoldController {
	ArrayList<String> activities = new ArrayList<String>();
	SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy h:mm a");

	@GetMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);			
		}
		return "index.jsp";
	}
	
	@PostMapping("/processMoney")
	public String processMoney(
			@RequestParam("area") String area,
			HttpSession session) {
		
		int max;
		int min;
		String start = "You entered a ";
		
		switch (area) {
			case "farm" :
				min = 10;
				max = 20;
				break;
			case "cave" :
				min = 5;
				max = 10;
				break;
			case "house" :
				min = 2;
				max = 5;
				break;
			case "spa":
				min = -20;
				max = -5;
				break;
			case "quest" :
				min = -50;
				max = 50;
				break;
			default:
				session.setAttribute("gold", 0);
				activities.clear();
				return "redirect:/ninjaGold";
		}
		int goldEarned = (int) (Math.random() * (max-min+1)) + min;
		if (area.equals("quest")) {
			start = goldEarned >= 0 ? "You completed a " : "You failed a ";
		}
		String textColor = goldEarned >=0 ? "green_text" : "red_text";
		session.setAttribute("gold", ((int) session.getAttribute("gold")) + goldEarned);
		if ((int) session.getAttribute("gold") < -100) {
			return "redirect:/ninjaGold/gameOver";
		}
		Date date = new Date();
		String timeStamp = "("+dateFormat.format(date)+")";
		activities.add(0,"<p class='" + textColor + "'>" + start + area + " and " + (goldEarned >= 0 ? "earned " : "lost ") + Math.abs(goldEarned) + " gold. "+timeStamp+"</p>");
		session.setAttribute("activities", activities);
		return "redirect:/ninjaGold";
	}
	
	@GetMapping("/gameOver")
	public String gameOver(HttpSession session) {
		activities.clear();
		session.setAttribute("debt", -1 * (int) session.getAttribute("gold"));
		session.setAttribute("gold", 0);
		session.setAttribute("activities", activities);
		return "gameOver.jsp";
	}
	
}
