package com.hashgo.room.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hashgo.room.dto.LoginDto;
import com.hashgo.room.dto.UserDto;
import com.hashgo.room.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//    @Operation(summary = "Register a new user", description = "Registers a user with email and phone number.")
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDto user ){
		return userService.registerUser(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserDto user){
		return userService.loginUser(user);
	}
	
	
	
	
	

}
