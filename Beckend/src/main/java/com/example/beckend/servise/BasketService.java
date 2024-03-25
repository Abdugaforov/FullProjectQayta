package com.example.beckend.servise;

import com.example.beckend.dto.BasketDto;
import com.example.beckend.entity.Basket;

import java.util.List;

public interface BasketService {
    List<Basket>getOrderByUserId(Long userId);
    Basket saveBasket(BasketDto dto);

}
