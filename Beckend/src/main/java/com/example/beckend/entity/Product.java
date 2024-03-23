package com.example.beckend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer productCount;
    private Boolean isActive;
    private Integer price;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;

    public Product(String name, Integer productCount, Boolean isActive, Integer price, Category category, User user) {
        this.name = name;
        this.productCount = productCount;
        this.isActive = isActive;
        this.price = price;
        this.category = category;
        this.user = user;
    }
}
