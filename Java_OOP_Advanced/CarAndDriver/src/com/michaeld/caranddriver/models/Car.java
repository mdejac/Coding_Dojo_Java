package com.michaeld.caranddriver.models;

public class Car {
	private int gas;
	
	public Car() {
		this.gas = 10;
	}

	public int getGas() {
		return gas;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}
	
	public Car displayGas() {
		System.out.println("Fuel remaining : " + this.gas + "/10");
		return this;
	}
}
