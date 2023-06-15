package com.michaeld.caranddriver.controllers;

import com.michaeld.caranddriver.models.Driver;

public class DriverController {

	public static void main(String[] args) {
		Driver player1 = new Driver();
		player1.drive().drive().drive().drive().useBoosters().drive().useBoosters().refuel().useBoosters().drive().drive();
	}

}
