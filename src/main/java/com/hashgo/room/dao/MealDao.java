package com.hashgo.room.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hashgo.room.entities.Meal;
import com.hashgo.room.repositories.MealRepo;

public class MealDao {

	@Autowired
	private MealRepo repo;

	public Meal getMealById(int id) {
		// TODO Auto-generated method stub
		Optional<Meal> meal=repo.findById(id);
		if(meal.isPresent()) {
			return meal.get();
		}else {
			return null;
		}
	}

	public void createMeal(Meal meal) {
		// TODO Auto-generated method stub
		repo.save(meal);
	}

	public List<Meal> findAllMeal() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Optional<Meal> meal=repo.findById(id);
		if(meal.isPresent()) {
			repo.delete(meal.get());
		}
		
	}

	public void updateMeal(Meal meal) {
		// TODO Auto-generated method stub
		Optional<Meal> optionalMeal=repo.findById(meal.getId());
		if(optionalMeal.isPresent()) {
			Meal updateMeal=optionalMeal.get();
			repo.save(updateMeal);
		}
		
	}
}
