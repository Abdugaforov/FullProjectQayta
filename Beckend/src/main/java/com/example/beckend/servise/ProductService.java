package com.example.beckend.servise;

import org.springframework.http.HttpEntity;

public interface ProductService {
    HttpEntity<?> getProductByCateGoryId(Long categoryId);
}
