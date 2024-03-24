package com.example.beckend.Controller;

import com.example.beckend.servise.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
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
}
