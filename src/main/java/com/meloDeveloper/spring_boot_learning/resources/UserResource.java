package com.meloDeveloper.spring_boot_learning.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meloDeveloper.spring_boot_learning.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L, "José", "jose@gmail.com", "61 9 9999-9999", "123321");
		return ResponseEntity.ok().body(user);
	}
}
