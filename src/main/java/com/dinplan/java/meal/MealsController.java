package com.dinplan.java.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/meals")
public class MealsController {
	
	@Autowired
	private MealRepository mealRepo;
	
	
	

}
