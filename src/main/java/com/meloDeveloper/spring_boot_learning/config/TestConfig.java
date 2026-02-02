package com.meloDeveloper.spring_boot_learning.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.meloDeveloper.spring_boot_learning.entities.Category;
import com.meloDeveloper.spring_boot_learning.entities.Order;
import com.meloDeveloper.spring_boot_learning.entities.OrderItem;
import com.meloDeveloper.spring_boot_learning.entities.Payment;
import com.meloDeveloper.spring_boot_learning.entities.Product;
import com.meloDeveloper.spring_boot_learning.entities.User;
import com.meloDeveloper.spring_boot_learning.enums.OrderStatus;
import com.meloDeveloper.spring_boot_learning.repositories.CategoryRepository;
import com.meloDeveloper.spring_boot_learning.repositories.OrderItemRepository;
import com.meloDeveloper.spring_boot_learning.repositories.OrderRepository;
import com.meloDeveloper.spring_boot_learning.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
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
		
		Product p1 = new Product(null, "Clean Code", "Classic book on writing maintainable and efficient code.", 45.0, "");
		Product p2 = new Product(null, "Samsung Smart TV 55\"", "4K UHD display with HDR and streaming apps built-in.", 799.0, "");
		Product p3 = new Product(null, "MacBook Air M3", "Lightweight laptop powered by Apple Silicon M3 chip.", 1499.0, "");
		Product p4 = new Product(null, "Gaming PC RTX 4070", "High-performance desktop with NVIDIA RTX 4070 graphics card.", 1899.0, "");
		Product p5 = new Product(null, "Spring Boot in Action", "Comprehensive guide to building modern web applications with Spring Boot.", 59.99, "");
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2026-01-28T12:22:49Z"), o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);
	}
}
