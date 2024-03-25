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

    @GetMapping("/all")
    public HttpEntity<?> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/by")
    public HttpEntity<?> getProductsByCategoryId(@RequestParam Long categoryId){
        return productService.getProductByCateGoryId(categoryId);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public HttpEntity<?> saveProduct(@RequestBody ProductDto dto) {
        return productService.saveProduct(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public HttpEntity<?> deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public HttpEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDto dto){
        return productService.updateProduct(id, dto);
    }
}
