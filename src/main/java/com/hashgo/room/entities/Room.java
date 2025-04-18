package com.hashgo.room.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private List<User> users;
	
	private List<Task> tasks;
	
	private List<Expense> expenes;

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

	public Room(int id, String name, List<User> users, List<Task> tasks, List<Expense> expenes) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.tasks = tasks;
		this.expenes = expenes;
	}

	public Room() {
		super();
	}
	
	
}
