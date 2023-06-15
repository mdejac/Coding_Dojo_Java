package com.michaeld.zookeeper.models;

public class Mammal {
	protected int energyLevel = 100;

	public int getEnergyLevel() {
		return this.energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy( ) {
		System.out.println("Current energy is : " + this.energyLevel);
		return this.energyLevel;
	}
	
	protected void increaseEnergy(int amount) {
		this.energyLevel += amount;

	}
	
	protected void decreaseEnergy(int amount) {
		if (this.energyLevel >= amount) {
			this.energyLevel -= amount;
		}
	}
}
