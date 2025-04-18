package com.hashgo.room.dto;

import java.util.List;

import com.hashgo.room.entities.Expense;
import com.hashgo.room.entities.Task;
import com.hashgo.room.entities.User;

public class RoomDto {
private long id;
	
	private String name;
	
	private List<User> users;
	
	private List<Task> tasks;
	
	private List<Expense> expenes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Expense> getExpenes() {
		return expenes;
	}

	public void setExpenes(List<Expense> expenes) {
		this.expenes = expenes;
	}

	public RoomDto(long id, String name, List<User> users, List<Task> tasks, List<Expense> expenes) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.tasks = tasks;
		this.expenes = expenes;
	}

	public RoomDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
