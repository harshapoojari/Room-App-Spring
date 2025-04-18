package com.hashgo.room.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hashgo.room.entities.Meal;

@Repository
public interface MealRepo extends JpaRepository<Meal, Integer>{

}
