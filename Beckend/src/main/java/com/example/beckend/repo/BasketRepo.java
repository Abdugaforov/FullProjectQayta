package com.example.beckend.repo;

import com.example.beckend.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepo extends JpaRepository<Basket,Long> {
}
