package com.michaeld.controllers;

import com.michaeld.models.Calculator;

public class CalculatorController {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		
		c.performOperation(10.5);
		c.performOperation("+");
		c.performOperation(5.2);
		c.performOperation("*");
		c.performOperation(10);
		c.performOperation("=");
		c.getResults();

	}

}
