package com.example.beckend.servise;

import com.example.beckend.dto.ProductDto;
import org.springframework.http.HttpEntity;

public interface ProductService {
    HttpEntity<?> getProductByCateGoryId(Long categoryId);

    HttpEntity<?> saveProduct(ProductDto dto);
}
