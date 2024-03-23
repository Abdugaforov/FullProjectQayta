package com.example.beckend.dto;

public record ProductDto(
         String name,
         Integer productCount,
         Boolean isActive,
         Integer price,

        Long  categoryId,
         Long userId
) {
}
