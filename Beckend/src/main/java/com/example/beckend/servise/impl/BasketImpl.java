package com.example.beckend.servise.impl;

import com.example.beckend.dto.BasketDto;
import com.example.beckend.entity.Basket;
import com.example.beckend.entity.Product;
import com.example.beckend.entity.User;
import com.example.beckend.repo.BasketRepo;
import com.example.beckend.repo.ProductRepo;
import com.example.beckend.repo.UserRepo;
import com.example.beckend.servise.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketImpl implements BasketService {
private final BasketRepo basketRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;



    @Override
    public List<Basket> getOrderByUserId(Long userId) {
        return basketRepo.findAllByUserId(userId);
    }

    @Override
    public Basket saveBasket(BasketDto dto) {
        User user = userRepo.findById(dto.userId()).orElseThrow();
        Product product = productRepo.findById(dto.productId()).orElseThrow();
        if (user!=null){
            Basket basket = Basket.builder()
                    .name(dto.name())
                    .productCount(dto.productCount())
                    .totalPrice(dto.totalPrice())
                    .product(product)
                    .user(user)
                    .build();
            return basketRepo.save(basket);
        }else return null;
    }
}
