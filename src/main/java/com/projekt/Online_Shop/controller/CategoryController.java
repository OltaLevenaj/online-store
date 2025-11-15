package com.projekt.Online_Shop.controller;

import com.projekt.Online_Shop.dto.CategoryDto;
import com.projekt.Online_Shop.entities.Author;
import com.projekt.Online_Shop.entities.Category;
import com.projekt.Online_Shop.services.AuthorService;
import com.projekt.Online_Shop.services.CategoryService;
import com.projekt.Online_Shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public Category create(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Category update(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(id, categoryDto.getName(), categoryDto.getParentId());
    }

    @GetMapping("/name")
    public Category  getByName(@RequestParam String name) {
        return categoryService.findByName(name);
    }

    @GetMapping("/search")
    public List<Category> searchByName(@RequestParam String name) {
        return categoryService.searchByName(name);
    }
    }


