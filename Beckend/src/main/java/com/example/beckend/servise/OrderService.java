package com.example.beckend.servise;

import com.example.beckend.dto.OrderDto;
import com.example.beckend.entity.Order;

import java.util.List;

public interface OrderService {

    Order saveOrder(OrderDto dto);
}
