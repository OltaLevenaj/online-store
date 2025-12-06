package com.projekt.Online_Shop.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data

public class OrderLine extends GenericEntity {

    private Integer numberOfProducts;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    private Double price;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public Double calculatePrice() {
        return product.getPrice() * numberOfProducts;
    }
}
