package com.example.demo.controller;

import com.example.demo.service.order.OrderService;
import com.example.demo.service.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public Order order(
            @RequestParam("member_id") Long memberId,
            @RequestParam("item_name") String itemName,
            @RequestParam("item_price") int itemPrice
    ) {
        return orderService.createOrder(
            memberId,
            itemName,
            itemPrice
        );
    }
}



