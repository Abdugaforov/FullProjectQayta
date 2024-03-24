package com.example.beckend.servise;

import com.example.beckend.entity.Basket;

import java.util.List;

public interface BasketService {
    List<Basket>getOrderByUserId(Long userId);

}
