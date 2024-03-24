package com.example.beckend.repo;

import com.example.beckend.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepo extends JpaRepository<Basket,Long> {

    List<Basket> findAllByUserId(Long userId);
}
