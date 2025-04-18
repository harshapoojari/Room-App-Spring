package com.hashgo.room.dto;

import java.sql.Date;

public class ExpenseDto {
	
private int id;
	
	private String itemName;
	
	private String cost;
	
	private Date date;
	
	private int userId;
	
	private String roomId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public ExpenseDto(int id, String itemName, String cost, Date date, int userId, String roomId) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.cost = cost;
		this.date = date;
		this.userId = userId;
		this.roomId = roomId;
	}

	public ExpenseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
