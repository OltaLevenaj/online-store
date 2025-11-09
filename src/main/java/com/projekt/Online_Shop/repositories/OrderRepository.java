package com.projekt.Online_Shop.repositories;

import com.projekt.Online_Shop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
