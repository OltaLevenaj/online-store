package com.projekt.Online_Shop.services;


import com.projekt.Online_Shop.dto.OrderDto;
import com.projekt.Online_Shop.entities.Order;
import com.projekt.Online_Shop.entities.OrderLine;
import com.projekt.Online_Shop.entities.UserAccount;
import com.projekt.Online_Shop.repositories.OrderRepository;
import com.projekt.Online_Shop.static_data.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserAccountService userAccountService;
    private final OrderLineService orderLineService;

    public Order create(OrderDto orderDto) {
        UserAccount userAccount = userAccountService.findLoggedIn();
        Order order = new Order();
        order.setUser(userAccount);
        order.setUserAddress(String.format("%s , %s, %s , %s" ,
                userAccount.getCountry(), userAccount.getCity(), userAccount.getStreet(), userAccount.getZipCode()));
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.UNPAID);
        order.setDeliveryAddress(orderDto.getDeliveryAddress());
        Order savedOrder = orderRepository.save(order);
        List<OrderLine> lines = orderLineService.getOrderLines(orderDto.getOrderLineIds());
        AtomicReference<Double> totalPrice = new AtomicReference<>();
        lines.forEach(line -> {
           totalPrice.set(totalPrice.get() + (line.getPrice() * line.getNumberOfProducts()));
           line.setOrder(savedOrder);
           orderLineService.save(line);
        });
        savedOrder.setTotalCoast(totalPrice.get());
        savedOrder.setOrderLines(lines);
        savedOrder.setOrderStatus(OrderStatus.PAID);
        return orderRepository.save(savedOrder);
    }


   public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);

   }

   public List<Order> findAll(){
        return orderRepository.findAll();
   }
   public Order cancel(Long id) {
        Order order = findById(id);
       if (order.getOrderStatus() == OrderStatus.PAID || order.getOrderStatus() == OrderStatus.UNPAID) {
           order.setOrderStatus(OrderStatus.CANCELLED);
           return orderRepository.save(order);
       } else {
           throw new RuntimeException("Order status is shipped");
       }
   }

    public Order update(Long id, OrderDto orderDto) {
        Order order = findById(id);
        if (order.getOrderStatus() == OrderStatus.PAID || order.getOrderStatus() == OrderStatus.UNPAID) {
            order.setDeliveryAddress(orderDto.getDeliveryAddress());
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Order is already shipped");
        }
    }

    public List<Order> getLoggedInOrders() {
        UserAccount userAccount = userAccountService.findLoggedIn();
        return orderRepository.findAllByUserAccount(userAccount);
    }
}