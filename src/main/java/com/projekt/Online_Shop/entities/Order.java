package com.projekt.Online_Shop.entities;

import com.projekt.Online_Shop.static_data.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order extends GenericEntity {
    private Double totalCoast;
    private String userAddress;
    private String deliveryAddress;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user;

    @OneToMany
    private List<OrderLine> orderLines = new ArrayList<>();




}
