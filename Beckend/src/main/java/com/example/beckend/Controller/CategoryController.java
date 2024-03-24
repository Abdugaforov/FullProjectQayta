package com.example.beckend.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.beckend.dto.CategoryDto;
import com.example.beckend.servise.CategoryService;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public HttpEntity<?> getCategories(){
        return categoryService.getAllCategory();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public HttpEntity<?> saveCategory(@RequestBody CategoryDto dto){
        return categoryService.saveCategory(dto);
    }
}
