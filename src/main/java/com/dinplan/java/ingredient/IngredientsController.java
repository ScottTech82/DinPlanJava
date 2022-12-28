package com.dinplan.java.ingredient;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping
public class IngredientsController {
	
	@Autowired
	private IngredientRepository ingRepo;
	
	
	@GetMapping
	public ResponseEntity<Iterable<Ingredient>> getIngredients() {
		Iterable<Ingredient> ingredient = ingRepo.findAll();
		return new ResponseEntity<Iterable<Ingredient>>(ingredient, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Ingredient> getIngredient(@PathVariable int id) {
		Optional<Ingredient> ingredient = ingRepo.findById(id);
		if(ingredient.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ingredient>(ingredient.get(), HttpStatus.OK);
	}
	

}
