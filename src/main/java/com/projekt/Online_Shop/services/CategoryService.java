package com.projekt.Online_Shop.services;

import com.projekt.Online_Shop.dto.CategoryDto;
import com.projekt.Online_Shop.entities.Category;
import com.projekt.Online_Shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    private  Category save(CategoryDto categoryDto ) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public List<Category> searchByName(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Category> searchByParentId(Long id) {
        return categoryRepository.findByParentId(id);
    }


    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }
    public Category findByName(String name) {
        return categoryRepository.findByName(name).orElseThrow(() -> new RuntimeException("Category not found"));
    }



    public Category addCategory(CategoryDto categoryDto) {
        if (categoryRepository.existsByName(categoryDto.getName())) {
            throw new RuntimeException("Category already exists");
        }

        Category category = new Category();
        category.setName(categoryDto.getName());


        if (categoryDto.getParentId() != null) {
            Category parent = categoryRepository.findById(categoryDto.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
            category.setParent(parent);
        } else {
            category.setParent(null);
        }
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, String categoryName, Long parentId) {
        Category category = findById(id);
        if (!category.getName().equals(categoryName)) {
            if (categoryRepository.existsByName(categoryName)) {
                throw new RuntimeException("Category already exists");
            }
            category.setName(categoryName);
            if (parentId != null) {
                Category parent = this.findById(parentId);
                category.setParent(parent);
            }
            return categoryRepository.save(category);
        }
        return category;
    }
}
