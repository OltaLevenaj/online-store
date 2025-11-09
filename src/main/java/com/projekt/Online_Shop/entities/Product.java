package com.projekt.Online_Shop.entities;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Table;
@Entity
@Table(name = "products")
@Data
public class Product extends GenericEntity {
    private String title;
    private String description;
    private String thumbnailUrl;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private boolean active;
}