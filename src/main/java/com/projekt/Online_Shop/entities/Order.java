package com.projekt.Online_Shop.entities;

import com.projekt.Online_Shop.static_data.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Order extends GenericEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user;
    private Double totalCoast;
    private String userAddress;
    private String deliveryAddress;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @OneToMany
    private List<OrderLine> orderLines = new ArrayList<>();




}
