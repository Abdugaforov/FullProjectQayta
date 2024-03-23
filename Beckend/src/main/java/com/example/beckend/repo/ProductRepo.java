package com.example.beckend.repo;

import com.example.beckend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {

    List<Product> findAllByCategoryId(Long categoryId);
}
