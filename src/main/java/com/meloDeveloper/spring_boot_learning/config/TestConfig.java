package com.meloDeveloper.spring_boot_learning.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.meloDeveloper.spring_boot_learning.entities.User;
import com.meloDeveloper.spring_boot_learning.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		List<User> users = new ArrayList<>();
		users.add(new User(null, "Victória", "victoria@gmail.com", "61 9 9999-9991", "1234"));
		users.add(new User(null, "Lavínia", "lavinia@gmail.com", "61 9 9999-9992", "2345"));
		users.add(new User(null, "Henrique", "henrique@gmail.com", "61 9 9999-9993", "3456"));
		
		userRepository.saveAll(users);
	}
	
	
}
