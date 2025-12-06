package com.projekt.Online_Shop.controller;

import com.projekt.Online_Shop.dto.OrderLineDto;
import com.projekt.Online_Shop.entities.OrderLine;
import com.projekt.Online_Shop.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderline")

public class OrderLineController {
    @Autowired
   private final OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

        @PostMapping
    private OrderLine createOrderLine(OrderLineDto orderLineDto) {return orderLineService.create(orderLineDto);}

    @GetMapping
    private List<OrderLine> getOrderLines() {return orderLineService.findAll();}

    @GetMapping("/{id}")
    public OrderLine getOrderLineById(@PathVariable Long id) {
        return orderLineService.findById(id);
    }

    @PutMapping("/update/{id}")
    public OrderLine updateOrderLine(@PathVariable Long id, @RequestBody OrderLineDto orderLineDto) {
        return orderLineService.update(id, orderLineDto);}

    @GetMapping("/ids")
    public List<OrderLine> getByIds(@RequestParam List<Long> ids) {
        return orderLineService.getOrderLines(ids);
    }

    @GetMapping("/by_order")
    public List<OrderLine> getByOrder(@RequestParam Long orderId) {
        return orderLineService.findByOrderId(orderId);
    }
    }
