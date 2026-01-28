package com.meloDeveloper.spring_boot_learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meloDeveloper.spring_boot_learning.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
