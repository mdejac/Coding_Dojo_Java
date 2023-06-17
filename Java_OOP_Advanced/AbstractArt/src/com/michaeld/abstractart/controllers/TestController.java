package com.michaeld.abstractart.controllers;

import com.michaeld.abstractart.models.Museum;
import com.michaeld.abstractart.models.Painting;
import com.michaeld.abstractart.models.Sculpture;

public class TestController {

	public static void main(String[] args) {
		Painting painting1 = new Painting("Painting 1", "MD", "First Test Painting", "Watercolor");
		Painting painting2 = new Painting("Painting 2", "MD", "Second Test Painting", "Oil");
		Painting painting3 = new Painting("Painting 3", "MD", "Third Test Painting", "Acrylic");
		
		Sculpture sculpture1 = new Sculpture("Sculpture 1", "MD", "First Test Sculpture", "Wood");
		Sculpture sculpture2 = new Sculpture("Sculpture 1", "MD", "Second Test Sculpture", "Clay");
		
		Museum m = new Museum();
		m.addPiece(painting1);
		m.addPiece(painting2);
		m.addPiece(painting3);
		m.addPiece(sculpture1);
		m.addPiece(sculpture2);
		
		m.displayArt();

	}

}
