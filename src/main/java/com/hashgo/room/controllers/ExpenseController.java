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

import com.hashgo.room.dto.ExpenseDto;
import com.hashgo.room.services.ExpenseService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/getExpenseById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id){
		return expenseService.getExpenseById(id);
	}
	
	@PostMapping("/createExpense")
	public ResponseEntity<?> createExpense(@RequestBody ExpenseDto expenseDto){
		return expenseService.createExpense(expenseDto);
	}
	
	@DeleteMapping("/deleteExpense/{id}")
	public ResponseEntity<?> deleteExpense(@PathVariable("id") int id){
		return expenseService.deleteExpense(id);
	}
	
	@PutMapping("/updateExpense/{id}")
	public ResponseEntity<?> updateExpense(@PathVariable("id") int id, @RequestBody ExpenseDto expenseDto){
		return expenseService.updateExpense(id, expenseDto);
	}
	
}