package com.dinplan.java.meal;

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
	

}
