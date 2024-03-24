package com.example.beckend.servise.impl;

import com.example.beckend.dto.ProductDto;
import com.example.beckend.entity.Category;
import com.example.beckend.entity.Product;
import com.example.beckend.entity.User;
import com.example.beckend.repo.CategoryRepo;
import com.example.beckend.repo.ProductRepo;
import com.example.beckend.repo.UserRepo;
import com.example.beckend.servise.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {
    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public HttpEntity<?> getProductByCateGoryId(Long categoryId) {
        return ResponseEntity.ok(productRepo.findAllByCategoryId(categoryId));
    }

    @Override
    public HttpEntity<?> saveProduct(ProductDto dto) {
        Category category = categoryRepo.findById(dto.categoryId()).orElseThrow();
        User user = userRepo.findById(dto.userId()).orElseThrow();
        productRepo.save(new Product(
                dto.name(),
                dto.productCount(),
                dto.isActive(),
                dto.price(),
                category,
                user
        ));

        return ResponseEntity.ok("product saved");
    }
}
