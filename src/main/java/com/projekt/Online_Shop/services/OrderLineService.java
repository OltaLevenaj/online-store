package com.projekt.Online_Shop.services;

import com.projekt.Online_Shop.dto.OrderLineDto;
import com.projekt.Online_Shop.entities.OrderLine;
import com.projekt.Online_Shop.entities.Product;
import com.projekt.Online_Shop.repositories.OrderLineRepository;
import com.projekt.Online_Shop.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final ProductService productService;


    public List<OrderLine> getOrderLines(List<Long> ids) {
        
        return orderLineRepository.findAllById(ids);
    }

    public OrderLine save(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    public OrderLine findById(Long id) {
        return orderLineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderLine me id " + id + " nuk u gjet!"));
    }
    public OrderLine update(Long id, OrderLineDto orderLineDto){
        OrderLine orderLine = findById(id);
        orderLine.setProduct(productService.getProductById(orderLineDto.getProductId()));
        orderLine.setPrice(orderLineDto.getPrice());
        return orderLineRepository.save(orderLine);
    }

    public OrderLine create(OrderLineDto orderLineDto) {
        OrderLine orderLine = new OrderLine();
        Product product = productService.getProductById(orderLineDto.getProductId());
        orderLine.setProduct(product);
        orderLine.setPrice(orderLineDto.getPrice());
        return orderLineRepository.save(orderLine);
    }

    public List<OrderLine> findAll() {
        return orderLineRepository.findAll();
    }
    public List<OrderLine> findByOrderId(Long orderId) {
        return orderLineRepository.findByOrderId(orderId);
    }

}
