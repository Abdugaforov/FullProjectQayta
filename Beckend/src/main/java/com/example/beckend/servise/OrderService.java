package com.example.beckend.servise;

import com.example.beckend.dto.OrderDto;
import com.example.beckend.entity.Order;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface OrderService {
<<<<<<<<< Temporary merge branch 1
    List<Order>getOrderByProductId(Long productId);

    HttpEntity<?> saveOrder(OrderDto dto);
=========
    List<Order>getOrderByUserId(Long userId);
>>>>>>>>> Temporary merge branch 2
}
