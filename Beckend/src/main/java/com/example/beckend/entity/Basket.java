package com.example.beckend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "basket")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer productCount;
    private Integer totalPrice;

    @ManyToOne
    Product product;
    @ManyToOne
    private User user;

    public Basket(String name, Integer productCount, Integer totalPrice,  Product product, User user) {
        this.name = name;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.product = product;
        this.user = user;
    }
}
