package com.example.beckend.dto;

public record BasketDto(

         String name,
         Integer productCount,
         Integer totalPrice,
         Long productId,

          Long userId

) {
}
