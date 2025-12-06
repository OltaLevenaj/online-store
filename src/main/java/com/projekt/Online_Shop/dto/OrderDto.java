package com.projekt.Online_Shop.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {
    private Long orderId;
    private Double price;
    private List<Long> orderLineIds;
    private String deliveryAddress;
}
