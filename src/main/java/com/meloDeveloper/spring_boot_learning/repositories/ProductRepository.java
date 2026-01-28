package com.meloDeveloper.spring_boot_learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meloDeveloper.spring_boot_learning.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
