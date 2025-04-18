package com.hashgo.room.dto;

import java.util.List;

import com.hashgo.room.entities.Meal;
import com.hashgo.room.entities.TaskType;

public class TaskDto {
private int id;
	
	private String name;
	
	private String day;
	
	private List<Meal> meals;
	
	private TaskType taskType;

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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public TaskDto(int id, String name, String day, List<Meal> meals, TaskType taskType) {
		super();
		this.id = id;
		this.name = name;
		this.day = day;
		this.meals = meals;
		this.taskType = taskType;
	}

	public TaskDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
