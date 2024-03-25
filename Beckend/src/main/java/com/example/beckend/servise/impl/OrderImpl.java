package com.example.beckend.servise.impl;

import com.example.beckend.dto.OrderDto;
import com.example.beckend.entity.Order;
import com.example.beckend.entity.Product;
import com.example.beckend.entity.User;
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
    private final ProductRepo productRepo;

    @Override
    public List<Order> getOrderByUserId(Long userId) {
        return orderRepo.findAllByUserId(userId);
    }

    @Override
    public Order saveOrder(OrderDto dto) {
        User user = userRepo.findById(dto.userId()).orElseThrow();
        if (user.getId()!=null){
            Order order = Order.builder()
                    .totalPrice(dto.totalPrice())
                    .user(user)
                    .build();

            return orderRepo.save(order);
        } else return null;
    }
}
