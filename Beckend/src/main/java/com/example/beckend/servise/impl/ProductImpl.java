package com.example.beckend.servise.impl;

import com.example.beckend.repo.ProductRepo;
import com.example.beckend.servise.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public HttpEntity<?> getProductByCateGoryId(Long categoryId) {
        return ResponseEntity.ok(productRepo.findAllByCategoryId(categoryId));
    }
}
