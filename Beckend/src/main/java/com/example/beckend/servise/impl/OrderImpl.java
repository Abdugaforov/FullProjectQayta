package com.example.beckend.servise.impl;

import com.example.beckend.dto.OrderDto;
import com.example.beckend.entity.Card;
import com.example.beckend.entity.Order;
import com.example.beckend.entity.Product;
import com.example.beckend.entity.User;
import com.example.beckend.repo.CardRepo;
import com.example.beckend.repo.OrderRepo;
import com.example.beckend.repo.ProductRepo;
import com.example.beckend.repo.UserRepo;
import com.example.beckend.servise.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final CardRepo cardRepo;
    private final ProductRepo productRepo;

    @Override
    public List<Order> getOrderByUserId(Long userId) {
        return orderRepo.findAllByUserId(userId);
    }

    @Override
    public Order saveOrder(OrderDto dto) {
        User user = userRepo.findById(dto.userId()).orElseThrow();
        Card card = cardRepo.findById(dto.cardId()).orElseThrow();
        Product product = productRepo.findById(dto.productId()).orElseThrow();
        if (user.getId()!=null){
            Order order = Order.builder()
                    .name(dto.name())
                    .productCount(dto.productCount())
                    .totalPrice(dto.totalPrice())
                    .product(product)
                    .user(user)
                    .card(card)
                    .build();
            return orderRepo.save(order);
        } else return null;
    }
}
