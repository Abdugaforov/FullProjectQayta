package com.example.beckend.repo;

import com.example.beckend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {

    List<Order> findAllByUserId(Long userId);

    List<Order> findAllByProductId(Long productId);
}
