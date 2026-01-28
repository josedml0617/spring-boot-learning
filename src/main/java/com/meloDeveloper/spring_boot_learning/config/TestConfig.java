package com.meloDeveloper.spring_boot_learning.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.meloDeveloper.spring_boot_learning.entities.Category;
import com.meloDeveloper.spring_boot_learning.entities.Order;
import com.meloDeveloper.spring_boot_learning.entities.User;
import com.meloDeveloper.spring_boot_learning.enums.OrderStatus;
import com.meloDeveloper.spring_boot_learning.repositories.CategoryRepository;
import com.meloDeveloper.spring_boot_learning.repositories.OrderRepository;
import com.meloDeveloper.spring_boot_learning.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		User u1 = new User(null, "Victória", "victoria@gmail.com", "61 9 9999-9991", "1234");
		User u2 = new User(null, "Lavínia", "lavinia@gmail.com", "61 9 9999-9992", "2345");
		User u3 = new User(null, "Henrique", "henrique@gmail.com", "61 9 9999-9993", "3456");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Order o1 = new Order(null, Instant.parse("2026-01-28T12:20:26Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2026-01-28T11:25:16Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2026-01-28T12:21:34Z"),OrderStatus.WAITING_PAYMENT, u1);
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
}
