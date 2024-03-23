package com.example.beckend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private User user;

    public Category(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
