package com.example.beckend.servise.impl;

import com.example.beckend.dto.CategoryDto;
import com.example.beckend.entity.Category;
import com.example.beckend.entity.User;
import com.example.beckend.repo.CategoryRepo;
import com.example.beckend.repo.UserRepo;
import com.example.beckend.servise.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final UserRepo userRepo;

    @Override
    public HttpEntity<?> getAllCategory() {
        return ResponseEntity.ok(categoryRepo.findAll());
    }

    @Override
    public HttpEntity<?> saveCategory(CategoryDto dto) {
        if (dto.name() != null && dto.userId() != null) {
            User user = userRepo.findById(dto.userId()).orElseThrow();
            Category save = categoryRepo.save(new Category(dto.name(), user));
        }
        return ResponseEntity.ok("saved");
    }
}
