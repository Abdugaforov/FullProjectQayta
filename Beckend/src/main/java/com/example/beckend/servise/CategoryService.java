package com.example.beckend.servise;

import com.example.beckend.dto.CategoryDto;
import org.springframework.http.HttpEntity;

public interface CategoryService {
    HttpEntity<?> getAllCategory();

    HttpEntity<?> saveCategory(CategoryDto dto);
}
