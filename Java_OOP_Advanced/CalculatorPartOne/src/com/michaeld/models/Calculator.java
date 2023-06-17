package com.michaeld.models;

public class Calculator implements java.io.Serializable {
	
	private double operandOne;
	private double operandTwo;
	private double result;
	private char operation;
	private static final long serialVersionUID = 1L;

	public Calculator() {}
	
	public void performOperation() {
		switch (this.operation) {
			case '+' :
				add();
				break;
			case '-' :
				subtract();
				break;
			default :
				System.out.println("Operator ERROR");
				break;
		}
	}
	
	public double getResults() {
		return this.result;
	}

	public double getOperandOne() {
		return this.operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return this.operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public char getOperation() {
		return this.operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}
	
	private void add() {
		this.result = this.operandOne + this.operandTwo;
	}
	
	private void subtract() {
		this.result = this.operandOne - this.operandTwo;
	}

}
