package com.hashgo.room.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hashgo.room.dao.ExpenseDao;
import com.hashgo.room.dto.ExpenseDto;
import com.hashgo.room.dto.ExpenseDtoMapper;
import com.hashgo.room.entities.Expense;
import com.hashgo.room.repositories.ExpenseRepo;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseDao expenseDao;
	
	@Autowired
	private ExpenseDtoMapper expenseDtoMapper;
	
	public ResponseEntity<?> getExpenseById(int id) {
	    Map<String, Object> response = new HashMap<String, Object>();
	    try {
	        Expense expense = expenseDao.getExpenseById(id);
	        if (expense != null) {
	            response.put("data", expenseDtoMapper.toExpenseDto(expense));
	            response.put("status", "200");
	            response.put("message", "Expense Found");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("status", "409");
	            response.put("message", "Expense Not Found");
	            return ResponseEntity.ok(response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
	public ResponseEntity<?> createExpense(ExpenseDto expenseDto) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        expenseDao.createExpense(expenseDtoMapper.toExpense(expenseDto));
	        response.put("status", "201");
	        response.put("message", "Expense Created Successfully");
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Creating Expense");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> updateExpense(int id, ExpenseDto expenseDto) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        if (expenseDao.getExpenseById(id)!=null) {
	        	expenseDto.setId(id);
	            expenseDao.updateExpense(expenseDtoMapper.toExpense(expenseDto));
	            response.put("status", "200");
	            response.put("message", "Expense Updated Successfully");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("status", "404");
	            response.put("message", "Expense Not Found");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Updating Expense");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> deleteExpense(int id) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        if (expenseDao.getExpenseById(id)!=null) {
	            expenseDao.deleteById(id);
	            response.put("status", "200");
	            response.put("message", "Expense Deleted Successfully");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("status", "404");
	            response.put("message", "Expense Not Found");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Deleting Expense");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> getAllExpenses() {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        List<Expense> expenses = expenseDao.findAllExpense();
	        response.put("data", expenses);
	        response.put("status", "200");
	        response.put("message", "Expenses Retrieved Successfully");
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Fetching Expenses");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}


}