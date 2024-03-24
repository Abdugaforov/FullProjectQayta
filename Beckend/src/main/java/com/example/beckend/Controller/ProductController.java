package com.example.beckend.Controller;

import com.example.beckend.dto.ProductDto;
import com.example.beckend.servise.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public HttpEntity<?> getProductsByCategoryId(@RequestParam Long categoryId){
        return productService.getProductByCateGoryId(categoryId);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public HttpEntity<?> saveProduct(@RequestBody ProductDto dto) {
        return productService.saveProduct(dto);
    }
}
