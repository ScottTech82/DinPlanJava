package com.dinplan.java.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class UsersController {
	
	@Autowired
	private UserRepository userRepo;

}
