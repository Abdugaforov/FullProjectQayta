package com.example.beckend.dto;

public record ProductDto(
        String name,
        Integer productCount,
        Boolean isActive,
        Integer price,
        String image,

        Long categoryId,
        Long userId
) {
}
