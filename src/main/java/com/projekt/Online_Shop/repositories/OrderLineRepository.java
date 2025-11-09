package com.projekt.Online_Shop.repositories;

import com.projekt.Online_Shop.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
