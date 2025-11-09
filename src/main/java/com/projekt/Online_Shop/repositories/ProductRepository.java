package com.projekt.Online_Shop.repositories;

import com.projekt.Online_Shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
