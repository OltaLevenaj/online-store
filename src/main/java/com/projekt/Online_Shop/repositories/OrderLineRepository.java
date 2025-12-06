package com.projekt.Online_Shop.repositories;

import com.projekt.Online_Shop.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

        List<OrderLine> findByOrderId(Long orderId);
    }

