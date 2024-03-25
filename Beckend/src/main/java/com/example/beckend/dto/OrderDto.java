package com.example.beckend.dto;

public record OrderDto(
         String name,
         Integer productCount,
         Integer totalPrice,

         Long productId,
         Long userId,
         Long cardId

) {
}
