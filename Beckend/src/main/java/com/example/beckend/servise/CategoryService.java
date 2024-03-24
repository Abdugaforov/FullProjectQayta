package com.example.beckend.servise;

import com.example.beckend.dto.CategoryDto;
import com.example.beckend.entity.Category;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface CategoryService {
    List<Category>getAllCategory();

    HttpEntity<?> saveCategory(CategoryDto dto);
}
