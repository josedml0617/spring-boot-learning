package com.meloDeveloper.spring_boot_learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meloDeveloper.spring_boot_learning.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
