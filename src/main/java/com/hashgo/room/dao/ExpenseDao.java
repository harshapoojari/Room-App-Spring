package com.hashgo.room.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hashgo.room.entities.Expense;
import com.hashgo.room.repositories.ExpenseRepo;

public class ExpenseDao {

	@Autowired
	private ExpenseRepo repo;

	public Expense getExpenseById(int id) {
		// TODO Auto-generated method stub
		Optional<Expense> expense=repo.findById(id);
		if(expense.isPresent()) {
			return expense.get();
		}else {
			return null;
		}
	}

	public void createExpense(Expense expense) {
		// TODO Auto-generated method stub
		repo.save(expense);
	}

	public List<Expense> findAllExpense() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Optional<Expense> expense=repo.findById(id);
		if(expense.isPresent()) {
			repo.delete(expense.get());
		}
		
	}

	public void updateExpense(Expense expense) {
		// TODO Auto-generated method stub
		Optional<Expense> optionalExpense=repo.findById(expense.getId());
		if(optionalExpense.isPresent()) {
			Expense updateExpense=optionalExpense.get();
			repo.save(updateExpense);
		}
		
	}

}
