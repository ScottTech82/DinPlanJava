package com.dinplan.java.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping
public class IngredientsController {
	
	@Autowired
	private IngredientRepository ingRepo;
	
	

}
