package com.michaeld.models;

import java.util.ArrayList;

public class Calculator implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Double> operands;
	private ArrayList<String> operators;
	private double results;

	public Calculator() {
		this.operands = new ArrayList<Double>();
		this.operators = new ArrayList<String>();
		
	}
	
	public void performOperation(double number) {
		this.operands.add(number);
	}
	
	public void performOperation(String operation) {
		this.operators.add(operation);
		if (operation.equals("=")) {
			calculateResults();
		}
	}
	
    private Double calculate(Double num1, String operator, Double num2){
        switch (operator){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                return num1 / num2;
        }
    }
	
	private void calculateResults() {
        while(this.operators.contains("*") || this.operators.contains("/")) {
            for(int i = 0; i < this.operators.size(); i++){
                if(this.operators.get(i) == "*" || this.operators.get(i) == "/"){
                    this.operands.set(i, calculate(this.operands.get(i), this.operators.get(i), this.operands.get(i+1)));
                    this.operands.remove(i+1);
                    this.operators.remove(i);
                }
            }
        }
        
        while(operators.contains("+") || operators.contains("-")){
        	this.operands.set(0, calculate(this.operands.get(0), operators.get(0), this.operands.get(1)));
        	this.operands.remove(1);
            this.operators.remove(0);
        }
		this.results = this.operands.get(0);
		this.operands.remove(0);
		this.operators.remove(0);
	}
	
	public void getResults() {
		System.out.println(this.results);
	}
}
