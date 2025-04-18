package com.hashgo.room.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public User(int id, String email, String phoneNo, String name, String password, String roomId) {
		super();
		this.id = id;
		this.email = email;
		this.phoneNo = phoneNo;
		this.name = name;
		this.password = password;
		this.roomId = roomId;
	}

	public User() {
		super();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(int id, String email, String phoneNo, String name, String password, String roomId, String role) {
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
