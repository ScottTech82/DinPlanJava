package com.dinplan.java.ingredient;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/ingredients")
public class IngredientsController {
	
	@Autowired
	private IngredientRepository ingRepo;
	
	
	@GetMapping
	public ResponseEntity<Iterable<Ingredient>> getIngredients() {
		Iterable<Ingredient> ingredient = ingRepo.findAll();
		return new ResponseEntity<Iterable<Ingredient>>(ingredient, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Ingredient> getIngredientByPK(@PathVariable int id) {
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
	
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}")
	public ResponseEntity putIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
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
	
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity deleteIngredient(@PathVariable int id) {
		Optional<Ingredient> ing = ingRepo.findById(id);
		if(ing.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		var x = ing.get();
		ingRepo.delete(x);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
