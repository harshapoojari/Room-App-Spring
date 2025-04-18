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

import com.hashgo.room.dto.MealDto;
import com.hashgo.room.services.MealService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/")
public class MealController {

	@Autowired
	private MealService mealService;
	
	@GetMapping("/getMealById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id){
		return mealService.getMealById(id);
	}
	
	@PostMapping("/createMeal")
	public ResponseEntity<?> createMeal(@RequestBody MealDto mealDto){
		return mealService.createMeal(mealDto);
	}
	
	@DeleteMapping("/deleteMeal/{id}")
	public ResponseEntity<?> deleteMeal(@PathVariable("id") int id){
		return mealService.deleteMeal(id);
	}
	
	@PutMapping("/updateMeal/{id}")
	public ResponseEntity<?> updateMeal(@PathVariable("id") int id, @RequestBody MealDto mealDto){
		return mealService.updateMeal(id, mealDto);
	}
}