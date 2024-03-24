package com.example.beckend.repo;

import com.example.beckend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Long> {

    List<Order> findAllByUserId(Long userId);
}
