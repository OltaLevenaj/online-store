package com.projekt.Online_Shop.repositories;

import com.projekt.Online_Shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByTitleContainingIgnoreCase(String title);

    List<Product> findByAuthorId(Long authorId);

    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByActiveTrue();

}
