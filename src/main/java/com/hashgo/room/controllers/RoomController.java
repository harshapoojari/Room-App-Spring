package com.hashgo.room.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hashgo.room.dao.RoomDao;
import com.hashgo.room.dto.RoomDto;
import com.hashgo.room.services.RoomService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/getRoomById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id){
		return roomService.getRoomById(id);
	}
	
	@PostMapping("/createRoom")
	public ResponseEntity<?> createRoom(@RequestBody RoomDto roomDto){
		return roomService.createRoom(roomDto);
	}
	
	@DeleteMapping("/deleteRoom/{id}")
	public ResponseEntity<?> deleteRoom(@PathVariable("id") int id){
		return roomService.deleteRoom(id);
	}
	
	@PutMapping("/updateRoom/{id}")
	public ResponseEntity<?> updateRoom(@PathVariable("id") int id, @RequestBody RoomDto roomDto){
		return roomService.updateRoom(id, roomDto);
	}
	
}