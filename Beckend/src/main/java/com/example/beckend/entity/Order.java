package com.example.beckend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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
    private Integer productCount;
    private Integer totalPrice;
    @CreationTimestamp
    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime soldOutTime;
    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;

    public Order(String name, Integer productCount, Integer totalPrice, Product product, User user) {
        this.name = name;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.product = product;
        this.user = user;
    }
}
