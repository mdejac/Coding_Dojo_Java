package com.michaeld.zookeeper.models;

public class Gorilla extends Mammal{
	
	public Gorilla throwSomething() {
		if (this.energyLevel >= 5) {
			System.out.println("Gorilla throws something.");
		} else {
			System.out.println("Gorilla does not have enough energy to throw anything.");
		}
		super.decreaseEnergy(5);
		return this;
	}
	
	public Gorilla eatBanana() {
		System.out.println("Mmmm Banana!");
		super.increaseEnergy(10);
		return this;
	}
	
	public Gorilla climb() {
		if (this.energyLevel >= 10) {
			System.out.println("Gorilla has climbed a tree.");
		} else {
			System.out.println("Gorilla does not have enough energy to climb a tree.");
		}
		super.decreaseEnergy(10);
		return this;
	}
}
