package com.michaeld.abstractart.models;

public class Sculpture extends Art {
	private String material;
	
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
	}

	@Override
	void viewArt() {
		System.out.println("Title : " + this.title);
		System.out.println("Author : " + this.author);
		System.out.println("Material : " + this.material);
		System.out.println("Description : " + this.description);
		System.out.println();
		
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
