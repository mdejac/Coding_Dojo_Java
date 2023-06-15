package com.michaeld.caresoftinterfaces.models;

import java.util.ArrayList;
import java.util.Date;

import com.michaeld.caresoftinterfaces.interfaces.HIPAACompliantAdmin;
import com.michaeld.caresoftinterfaces.interfaces.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private String role;
	private ArrayList<String> securityIncidents;
	
	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return this.securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		boolean isValidPin = pin == 0 ? false : (int)(Math.log10(pin) + 1) == 6 ? true : false;
		if (isValidPin) {
			this.pin = pin;
			return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.id != confirmedAuthID) {
			authIncident();
			return false;
		}
		return true;
	}
	
	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted : %s \n, Reported by ID : %s\n Notes : %s \n", new Date(), this.id, notes);
		securityIncidents.add(report);
	}
	
	public void authIncident() {
		String report = String.format("Datetime Submitted : %s \n, ID : %s\n Notes : %s \n", new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}

	public String getRole() {
		return this.role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public ArrayList<String> getSecurityIncidents() {
		return this.securityIncidents;
	}
	
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
}
