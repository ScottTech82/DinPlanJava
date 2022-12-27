package com.dinplan.java.meal;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/meals")
public class MealsController {
	
	@Autowired
	private MealRepository mealRepo;
	
	@GetMapping
	public ResponseEntity<Iterable<Meal>> getMeals() {
		Iterable<Meal> meal = mealRepo.findAll();
		return new ResponseEntity<Iterable<Meal>>(meal, HttpStatus.OK);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Meal> getMealsById(@PathVariable int id) {
		Optional<Meal> meal = mealRepo.findById(id);
		if(meal.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Meal>(meal.get(), HttpStatus.OK );
	}
	

}
