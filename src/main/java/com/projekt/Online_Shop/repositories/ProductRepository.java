package com.projekt.Online_Shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductRepository,Long> {
    Optional<ProductRepository> findByTittle(String tittle);
}
