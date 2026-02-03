package com.meloDeveloper.spring_boot_learning.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meloDeveloper.spring_boot_learning.entities.User;
import com.meloDeveloper.spring_boot_learning.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
}
