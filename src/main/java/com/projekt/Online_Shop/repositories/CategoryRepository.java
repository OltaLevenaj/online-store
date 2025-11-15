package com.projekt.Online_Shop.repositories;

import com.projekt.Online_Shop.entities.Category;
import jdk.jfr.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);
    Boolean existsByName(String name);
    List<Category>findByNameContainingIgnoreCase(String name);
    List<Category>findByParentId(Long id);

}
