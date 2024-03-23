package com.example.beckend.servise.impl;

import com.example.beckend.entity.Order;
import com.example.beckend.repo.BasketRepo;
import com.example.beckend.servise.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketImpl implements BasketService {
private final BasketRepo basketRepo;

    @Override
    public List<Order> getOrderByProductId(Long productId) {
        return null;
    }
}
