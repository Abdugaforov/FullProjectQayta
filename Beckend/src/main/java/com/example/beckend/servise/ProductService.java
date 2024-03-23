package com.example.beckend.servise;

import com.example.beckend.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product>getProductByCateGoryId(Long categoryId);
}
