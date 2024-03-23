package com.example.beckend.servise;

import com.example.beckend.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order>getOrderByProductId(Long productId);
}
