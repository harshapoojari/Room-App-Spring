package com.hashgo.room.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hashgo.room.dao.MealDao;
import com.hashgo.room.dto.MealDto;
import com.hashgo.room.dto.MealDtoMapper;
import com.hashgo.room.entities.Meal;

@Service
public class MealService {
	@Autowired
	private MealDao mealDao;

	@Autowired
	private MealDtoMapper mealDtoMapper;

	public ResponseEntity<?> getMealById(int id) {
	    Map<String, Object> response = new HashMap<String, Object>();
	    try {
	        Meal meal = mealDao.getMealById(id);
	        if (meal != null) {
	            response.put("data", mealDtoMapper.toMealDto(meal));
	            response.put("status", "200");
	            response.put("message", "Meal Found");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("status", "409");
	            response.put("message", "Meal Not Found");
	            return ResponseEntity.ok(response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
	
	public ResponseEntity<?> createMeal(MealDto mealDto) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        mealDao.createMeal(mealDtoMapper.toMeal(mealDto));
	        response.put("status", "201");
	        response.put("message", "Meal Created Successfully");
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Creating Meal");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> updateMeal(int id, MealDto mealDto) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        if (mealDao.getMealById(id)!=null) {
	            mealDto.setId(id);
	            mealDao.updateMeal(mealDtoMapper.toMeal(mealDto));
	            response.put("status", "200");
	            response.put("message", "Meal Updated Successfully");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("status", "404");
	            response.put("message", "Meal Not Found");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Updating Meal");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> deleteMeal(int id) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        if (mealDao.getMealById(id)!=null) {
	            mealDao.deleteById(id);
	            response.put("status", "200");
	            response.put("message", "Meal Deleted Successfully");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("status", "404");
	            response.put("message", "Meal Not Found");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Deleting Meal");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> getAllMeals() {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        List<Meal> meals = mealDao.findAllMeal();
	        response.put("data", meals);
	        response.put("status", "200");
	        response.put("message", "Meals Retrieved Successfully");
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Fetching Meals");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

}