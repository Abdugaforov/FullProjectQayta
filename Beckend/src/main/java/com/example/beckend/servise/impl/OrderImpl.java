package com.example.beckend.servise.impl;

import com.example.beckend.dto.OrderDto;
import com.example.beckend.entity.Order;
import com.example.beckend.repo.OrderRepo;
import com.example.beckend.servise.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderImpl implements OrderService {
    private OrderRepo orderRepo;


    @Override
    public List<Order> getOrderByProductId(Long productId) {
        return orderRepo.findAllByProductId(productId);
    }

    @Override
    public HttpEntity<?> saveOrder(OrderDto dto) {
        return null;
    }
}
