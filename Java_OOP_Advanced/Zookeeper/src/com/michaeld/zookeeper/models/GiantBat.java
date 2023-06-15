package com.michaeld.zookeeper.models;

public class GiantBat extends Mammal {
	
	public GiantBat() {
		this.energyLevel = 300;
	}
	
	public GiantBat fly() {
		if (this.energyLevel >= 50) {
			System.out.println("SwooooOOOOOOoooooossssshhhhhhh!");
		}  else {
			System.out.println("Giant Bat does not have enough energy to fly.");
		}
		super.decreaseEnergy(50);
		return this;
	}
	
	public GiantBat eatHuman(){
		System.out.println("GiantBat feels nourished from eating humans.");
		super.increaseEnergy(25);
		return this;
	}
	
	public GiantBat attackTown() {
		if (this.energyLevel >= 100) {
			System.out.println("Bang, crackle, crash, boom!  Ahhhhhh! Aaaahhhh!!");
		}  else {
			System.out.println("GiantBat does not have enough energy to destroy a town.");
		}
		super.decreaseEnergy(100);
		return this;
	}
}
