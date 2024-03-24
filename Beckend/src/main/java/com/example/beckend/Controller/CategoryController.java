package com.example.beckend.Controller;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
=======
import com.example.beckend.dto.CategoryDto;
import com.example.beckend.servise.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> github/master
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public HttpEntity<?> saveCategory(@RequestBody CategoryDto dto){
        return categoryService.saveCategory(dto);
    }
}
