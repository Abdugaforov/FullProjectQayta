package com.example.beckend.servise.impl;

import com.example.beckend.entity.Product;
import com.example.beckend.repo.ProductRepo;
import com.example.beckend.servise.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public List<Product> getProductByCateGoryId(Long categoryId) {
        return null;
    }
}
