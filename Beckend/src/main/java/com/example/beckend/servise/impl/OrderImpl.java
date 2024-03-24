package com.example.beckend.servise.impl;

import com.example.beckend.entity.Order;
import com.example.beckend.repo.OrderRepo;
import com.example.beckend.servise.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderImpl implements OrderService {
    private OrderRepo orderRepo;


    @Override
    public List<Order> getOrderByUserId(Long userId) {
        return orderRepo.findAllByUserId(userId);
    }
}
