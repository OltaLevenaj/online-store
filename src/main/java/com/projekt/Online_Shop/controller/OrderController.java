package com.projekt.Online_Shop.controller;


import com.projekt.Online_Shop.dto.OrderDto;
import com.projekt.Online_Shop.entities.Order;
import com.projekt.Online_Shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping
    public Order createOrder(OrderDto orderDto) {
        return orderService.create(orderDto);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }



    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    // UPDATE order
    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        return orderService.update(id, orderDto);
    }


    @DeleteMapping("/cancel/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.cancel(id);
    }

    @GetMapping("/by_logged_user")
    public List<Order> getOrdersByLoggedUser() {
        return orderService.getLoggedInOrders();
    }
}