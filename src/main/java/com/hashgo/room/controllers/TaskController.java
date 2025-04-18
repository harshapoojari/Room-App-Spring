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

import com.hashgo.room.dto.TaskDto;
import com.hashgo.room.services.TaskService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/getTaskById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id){
		return taskService.getTaskById(id);
	}
	
	@PostMapping("/createTask")
	public ResponseEntity<?> createTask(@RequestBody TaskDto taskDto){
		return taskService.createTask(taskDto);
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable("id") int id){
		return taskService.deleteTask(id);
	}
	
	@PutMapping("/updateTask/{id}")
	public ResponseEntity<?> updateTask(@PathVariable("id") int id, @RequestBody TaskDto taskDto){
		return taskService.updateTask(id, taskDto);
	}

}