package com.example.beckend.Controller;

import com.example.beckend.dto.OrderDto;
import com.example.beckend.entity.Order;
import com.example.beckend.servise.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public HttpEntity<?> saveOrder(@RequestBody OrderDto dto){
        Order order = orderService.saveOrder(dto);
        return ResponseEntity.ok(order);
    }
    @GetMapping
    public HttpEntity<?> getOrderByUserId(@RequestParam Long userId){
        List<Order>order = orderService.getOrderByUserId(userId);
        return ResponseEntity.ok(order);
    }

}
