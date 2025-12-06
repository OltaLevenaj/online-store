package com.projekt.Online_Shop.repositories;

import com.projekt.Online_Shop.entities.Order;
import com.projekt.Online_Shop.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByUserAccount(UserAccount userAccount);
}
