package com.hashgo.room.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hashgo.room.entities.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Integer>{

}
