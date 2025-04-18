package com.hashgo.room.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserDto {
	
	private int id;
	
	private String email;
	
	private String phoneNo;
	
	private String name;
	
	private String password;
	
	private String roomId;
	
	private String role;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public UserDto(int id, String email, String phoneNo, String name, String password, String roomId) {
		super();
		this.id = id;
		this.email = email;
		this.phoneNo = phoneNo;
		this.name = name;
		this.password = password;
		this.roomId = roomId;
	}

	public UserDto() {
		super();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDto(int id, String email, String phoneNo, String name, String password, String roomId, String role) {
		super();
		this.id = id;
		this.email = email;
		this.phoneNo = phoneNo;
		this.name = name;
		this.password = password;
		this.roomId = roomId;
		this.role = role;
	}
	
	
	
	

}
