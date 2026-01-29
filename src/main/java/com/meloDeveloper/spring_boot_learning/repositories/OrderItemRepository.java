package com.meloDeveloper.spring_boot_learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meloDeveloper.spring_boot_learning.entities.OrderItem;
import com.meloDeveloper.spring_boot_learning.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem,OrderItemPK>{

}
