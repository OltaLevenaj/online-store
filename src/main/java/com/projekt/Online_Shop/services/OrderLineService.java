package com.projekt.Online_Shop.services;

import com.projekt.Online_Shop.entities.OrderLine;
import com.projekt.Online_Shop.repositories.OrderLineRepository;
import com.projekt.Online_Shop.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderRepository orderRepository;
    private final UserAccountService userAccountService;
    private final OrderLineRepository orderLineRepository;


    public List<OrderLine> getOrderLines(List<Long> ids) {
        return orderLineRepository.findAllById(ids);
    }

    public OrderLine save(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }
}