package com.projekt.Online_Shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Long categoryId;
    private Long authorId;
}
