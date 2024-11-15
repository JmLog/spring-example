package com.example.demo.service.order;

import com.example.demo.service.order.entity.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
