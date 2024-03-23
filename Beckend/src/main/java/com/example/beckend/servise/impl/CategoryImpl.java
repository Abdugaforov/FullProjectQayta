package com.example.beckend.servise.impl;

import com.example.beckend.entity.Category;
import com.example.beckend.repo.CategoryRepo;
import com.example.beckend.servise.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }
}
