package com.dinplan.java.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	Optional<User> findByCode(String code);

}
