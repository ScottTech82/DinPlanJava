package com.dinplan.java.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class UsersController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping
	public ResponseEntity<Iterable<User>> getUsers() {
		Iterable<User> x = userRepo.findAll();
		return new ResponseEntity<Iterable<User>>(x, HttpStatus.OK);
	}
	
	

}
