package com.michaeld.abstractart.models;

import java.util.ArrayList;

public class Museum {

	private ArrayList<Art> pieces;
	
	public Museum() {
		this.pieces = new ArrayList<Art>();
	}
	
	public void addPiece(Art piece) {
		this.pieces.add(piece);
	}
	
	public void displayArt() {
		for (Art obj : pieces) {
			obj.viewArt();
		}
	}

	public ArrayList<Art> getPieces() {
		return this.pieces;
	}

	public void setPieces(ArrayList<Art> pieces) {
		this.pieces = pieces;
	};
}
