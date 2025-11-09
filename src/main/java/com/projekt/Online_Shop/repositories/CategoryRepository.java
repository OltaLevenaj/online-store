package com.projekt.Online_Shop.repositories;

import com.projekt.Online_Shop.entities.Category;
import jdk.jfr.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
    List<Category>findByNameContainingIgnoreCase(String name);


}
