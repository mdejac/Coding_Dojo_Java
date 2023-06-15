package com.michaeld.caresoftinterfaces.models;

import com.michaeld.caresoftinterfaces.interfaces.HIPAACompliantUser;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;

	public Physician(Integer id) {
		super(id);
		this.patientNotes = new ArrayList<String>();
	}

	@Override
	public boolean assignPin(int pin) {
		boolean isValidPin = pin == 0 ? false : (int)(Math.log10(pin)+ 1) == 4 ? true : false;
		if (isValidPin) {
			this.pin = pin;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		return this.id == confirmedAuthID ? true : false;
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime Submitted: %s \n", date);
		report += String.format("Reported by ID : %s\n", this.id);
		report += String.format("Patient Name : %s\n", patientName);
		report += String.format("Notes : %s \n", notes);
		this.patientNotes.add(report);
	}

	public ArrayList<String> getPatientNotes() {
		return this.patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	
}
