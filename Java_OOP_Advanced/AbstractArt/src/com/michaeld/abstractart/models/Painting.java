package com.michaeld.abstractart.models;

public class Painting extends Art {
	private String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}
	
	@Override
	void viewArt() {
		System.out.println("Title : " + this.title);
		System.out.println("Author : " + this.author);
		System.out.println("Paint Type : " + this.paintType);
		System.out.println("Description : " + this.description);
		System.out.println();
		
	}
	
	public String getPaintType() {
		return this.paintType;
	}
	
	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

}
