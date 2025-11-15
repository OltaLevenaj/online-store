package com.projekt.Online_Shop.services;

import com.projekt.Online_Shop.entities.Author;
import com.projekt.Online_Shop.entities.Category;
import com.projekt.Online_Shop.entities.Product;
import com.projekt.Online_Shop.dto.ProductDto;
import com.projekt.Online_Shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private final ProductRepository productRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired

    public ProductService(ProductRepository productRepository, AuthorService authorService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        return save(productDto, product);
    }

    private Product save(ProductDto productDto, Product product) {
        product.setActive(true);
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setAuthor(authorService.findAuthorById(productDto.getAuthorId()));
        product.setCategory(categoryService.findById(productDto.getCategoryId()));
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllActiveProducts() {
return productRepository.findByActiveTrue();
    }




    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
    }


    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        product.setActive(false);
        productRepository.save(product);
    }

    public Product updateProduct(ProductDto updatedProduct) {
        Product product = getProductById(updatedProduct.getId());
        return save(updatedProduct, product);
    }

    public List<Product> findByAuthorId(Long authorId) {
        return productRepository.findByAuthorId(authorId);
    }

    public List<Product> findByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> findByTitle(String title) {
        return productRepository.findByTitleContainingIgnoreCase(title);
    }

}









