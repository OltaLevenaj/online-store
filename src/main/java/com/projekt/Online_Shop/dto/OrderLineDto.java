package com.projekt.Online_Shop.dto;

import lombok.Data;

@Data
public class OrderLineDto {
    private Long id;
    private Long productId;
    private Double price;
    }

