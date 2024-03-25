package com.example.beckend.repo;

import com.example.beckend.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card,Long> {

}
