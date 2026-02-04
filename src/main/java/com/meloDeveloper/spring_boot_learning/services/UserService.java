package com.meloDeveloper.spring_boot_learning.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meloDeveloper.spring_boot_learning.entities.User;
import com.meloDeveloper.spring_boot_learning.repositories.UserRepository;
import com.meloDeveloper.spring_boot_learning.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(()->new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		dataUpdate(entity,obj);
		return repository.save(entity);
		
	}
	
	private User dataUpdate(User entity, User obj){
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		return entity;
	}
}
