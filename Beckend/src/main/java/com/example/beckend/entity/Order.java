package com.example.beckend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer count;
    private Integer totalPrice;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;

    public Order(String name, Integer count, Integer totalPrice, Product product, User user) {
        this.name = name;
        this.count = count;
        this.totalPrice = totalPrice;
        this.product = product;
        this.user = user;
    }
}
