package com.example.beckend.dto;

import com.example.beckend.entity.Product;

public record OrderProductDto(
        Product product,
        Integer count
) {
}
