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
	
	@PostMapping
	public ResponseEntity<Ingredient> postIngredient(@RequestBody Ingredient ingredient) {
		if(ingredient.getId() != 0 || ingredient == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Ingredient newIngd = ingRepo.save(ingredient);
		return new ResponseEntity<Ingredient>(newIngd, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Ingredient> putIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
		if(id != ingredient.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
		Optional<Ingredient> x = ingRepo.findById(ingredient.getId());
		if(x.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ingRepo.save(ingredient);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	

}
