package com.projekt.Online_Shop.controller;

import com.projekt.Online_Shop.entities.Product;
import com.projekt.Online_Shop.dto.ProductDto;
import com.projekt.Online_Shop.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) { this.productService = productService; }

    @GetMapping("/all")
    public List<Product> getAll() { return productService.getAllProducts(); }

    @GetMapping("/active")
    public List<Product> getActiveProducts() {
        return productService.getAllActiveProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/create")
    public Product create(@RequestBody ProductDto product) {
        return productService.createProduct(product);
    }

    @PutMapping("/update")
    public Product update(@RequestBody ProductDto updatedProduct) {
        return productService.updateProduct(updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }



    @GetMapping("/search/title")
    public List<Product> findByTitle(@RequestParam String title) {
        return productService.findByTitle(title);
    }

    @GetMapping("/search/author/{authorId}")
    public List<Product> findByAuthor(@PathVariable Long authorId) {
        return productService.findByAuthorId(authorId);
    }

    @GetMapping("/search/category/{categoryId}")
    public List<Product> findByCategory(@PathVariable Long categoryId) {
        return productService.findByCategoryId(categoryId);
    }


}