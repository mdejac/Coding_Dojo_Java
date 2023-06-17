package com.michaeld.controllers;

import com.michaeld.models.Calculator;

public class CalculatorController {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		
		c.setOperandOne(10.5);
		c.setOperation('+');
		c.setOperandTwo(5.2);
		c.performOperation();
		System.out.println(c.getResults());
		
		c.setOperandOne(10.5);
		c.setOperation('-');
		c.setOperandTwo(5.2);
		c.performOperation();
		System.out.println(c.getResults());

	}

}
