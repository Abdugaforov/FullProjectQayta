package com.example.beckend.dto;

import java.util.List;

public record OrderDto(
         Integer totalPrice,
         Long userId,
         List<OrderProductDto> orderProducts

) {
}
