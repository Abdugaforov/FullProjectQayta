package com.example.beckend.dto;

public record OrderDto(
         String name,
         Integer count,
         Integer totalPrice,

         Long productId

) {
}
