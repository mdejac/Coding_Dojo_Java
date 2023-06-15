package com.michaeld.zookeeper.controllers;

import com.michaeld.zookeeper.models.*;

public class GorillaController {

	public static void main(String[] args) {
		Gorilla mojoJojo = new Gorilla();
		mojoJojo.throwSomething().throwSomething().throwSomething().eatBanana().eatBanana().climb().displayEnergy();
	
		GiantBat mothra = new GiantBat();
		mothra.attackTown().attackTown().attackTown().eatHuman().eatHuman().fly().fly().displayEnergy();
	}

}
