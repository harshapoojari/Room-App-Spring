package com.hashgo.room.dto;

public class MealDto {
private int id;
	
	private String name;
	
	private String steps;
	
	private String ingredients;
	
	private String link;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public MealDto(int id, String name, String steps, String ingredients, String link) {
		super();
		this.id = id;
		this.name = name;
		this.steps = steps;
		this.ingredients = ingredients;
		this.link = link;
	}

	public MealDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
