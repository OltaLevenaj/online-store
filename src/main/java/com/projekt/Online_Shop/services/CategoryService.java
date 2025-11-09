package com.projekt.Online_Shop.services;

import com.projekt.Online_Shop.entities.Category;
import com.projekt.Online_Shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category>getAll(){
        return  categoryRepository.findAll();
    }
    public Category findById(Long id){
        return  categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
    }


}
