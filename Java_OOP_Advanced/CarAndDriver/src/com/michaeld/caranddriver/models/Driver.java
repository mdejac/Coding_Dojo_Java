package com.michaeld.caranddriver.models;

public class Driver extends Car {
	private boolean hasFuel = true;
	
	public Driver drive( ) {
		moveCar(1, "You drive the car.");					
		return this;
	}
	
	public Driver useBoosters( ) {
		moveCar(3, "You engage boosters.");
		return this;
	}
	
	public Driver refuel() {
		if (getHasFuel()) {
			if (super.getGas() < 9 && super.getGas() > 0) {
				super.setGas(super.getGas()+2);
				System.out.println("You refuled the car.");
			} else {
				System.out.println("Tank is too full!");
			}
		} else {
			gameOverMessage();
		}
		super.displayGas();						
		return this;
	}
	
	private boolean reduceGas(int amount) {
		int remainingFuel = super.getGas();
		if (super.getGas() >= amount) {
			super.setGas(remainingFuel - amount);
			if (super.getGas() == 0) {
				setHasFuel(false);
			}
			return true;
		}
		if (getHasFuel()) {
			System.out.println("Insufficient fuel to use boosters.");
		}
		return false;
	}
	
	public boolean getHasFuel() {
		return this.hasFuel;
	}

	public void setHasFuel(boolean hasFuel) {
		this.hasFuel = hasFuel;
	}
	
	private void moveCar(int amount, String msg) {
		if (getHasFuel() && reduceGas(amount)) {
			System.out.println(msg);
		}
		if (!getHasFuel()) {
			gameOverMessage();
		}
		super.displayGas();	
	}

	private void gameOverMessage() {
		System.out.println("You have ran out of fuel. Game Over!");
	}
}
