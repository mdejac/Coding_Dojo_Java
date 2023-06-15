package com.michaeld.caresoftinterfaces.models;

public class User {
	protected Integer id;
	protected int pin;
	
	public User(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return this.pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
}
