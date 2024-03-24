package com.example.beckend.servise;

import com.example.beckend.dto.OrderDto;
import com.example.beckend.entity.Order;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface OrderService {
    List<Order>getOrderByProductId(Long productId);

    default HttpEntity<?> saveOrder(OrderDto dto) {
        return null;
    }
}
