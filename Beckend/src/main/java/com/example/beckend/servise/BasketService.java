package com.example.beckend.servise;

import com.example.beckend.entity.Order;

import java.util.List;

public interface BasketService {
    List<Order>getOrderByProductId(Long productId);

}
