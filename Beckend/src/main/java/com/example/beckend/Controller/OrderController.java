package com.example.beckend.Controller;

import com.example.beckend.dto.OrderDto;
import com.example.beckend.entity.Order;
import com.example.beckend.security.servise.JwtServise;
import com.example.beckend.servise.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final JwtServise jwtServise;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public HttpEntity<?> saveOrder(@RequestHeader String refreshToken, @RequestBody OrderDto dto){
        Order order = orderService.saveOrder(Long.parseLong(jwtServise.extractJwt(refreshToken).getPayload().getSubject()),dto);
        return ResponseEntity.ok(order);
    }

}
