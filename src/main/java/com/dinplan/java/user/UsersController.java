package com.dinplan.java.user;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping
	public ResponseEntity<Iterable<User>> getUsers() {
		Iterable<User> x = userRepo.findAll();
		return new ResponseEntity<Iterable<User>>(x, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<User> getUserByPK(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}
	
	@GetMapping("username/{username}")
	public ResponseEntity<User> getUserByCode(@PathVariable String code) {
		Optional<User> user = userRepo.findByCode(code);
		if(user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user.get(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> postUser(@RequestBody User user){
		if(user.getId() !=0 || user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		User newUser = userRepo.save(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
	
	
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}")
	public ResponseEntity putUser(@PathVariable int id, @RequestBody User user) {
		if(id != user.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<User> x = userRepo.findById(user.getId());
		if(x.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userRepo.save(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		var x = user.get();
		userRepo.delete(x);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	

}
