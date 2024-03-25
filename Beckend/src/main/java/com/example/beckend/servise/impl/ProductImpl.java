package com.example.beckend.servise.impl;

import com.example.beckend.dto.ProductDto;
import com.example.beckend.entity.Category;
import com.example.beckend.entity.Product;
import com.example.beckend.entity.User;
import com.example.beckend.repo.CategoryRepo;
import com.example.beckend.repo.ProductRepo;
import com.example.beckend.repo.UserRepo;
import com.example.beckend.servise.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {
    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public HttpEntity<?> getProductByCateGoryId(Long categoryId) {
        return ResponseEntity.ok(productRepo.findAllByCategoryId(categoryId));
    }

    @Override
    public HttpEntity<?> saveProduct(ProductDto dto) {
        Category category = categoryRepo.findById(dto.categoryId()).orElseThrow();
        User user = userRepo.findById(dto.userId()).orElseThrow();
        if (dto.name() != null && dto.productCount() != null && dto.productCount() > 0
                && dto.price() != null && dto.price() > 0
                && category.getId() != null && user.getId() != null
                && dto.image() != null
        ) {
            productRepo.save(
                    Product.builder()
                            .name(dto.name())
                            .productCount(dto.productCount())
                            .isActive(true)
                            .price(dto.price())
                            .image(dto.image())
                            .category(category)
                            .user(user)
                            .build()
            );
        }
        return ResponseEntity.ok("product saved");
    }

    @Override
    public HttpEntity<?> deleteProductById(Long id) {
        productRepo.deleteById(id);
        return ResponseEntity.ok("product deleted");
    }

    @Override
    public HttpEntity<?> updateProduct(Long id, ProductDto dto) {
        Category category = categoryRepo.findById(dto.categoryId()).orElseThrow();
        User user = userRepo.findById(dto.userId()).orElseThrow();
        Product product = productRepo.findById(id).orElseThrow();
        if (dto.name() != null && dto.productCount() != null && dto.price() != null
                && category.getId() != null && user.getId() != null
        ) {
            product.setName(dto.name());
            product.setProductCount(dto.productCount());
            product.setIsActive(dto.isActive());
            product.setPrice(dto.price());
            product.setUser(user);
            product.setCategory(category);
        }
        return ResponseEntity.ok("updated");
    }

    @Override
    public HttpEntity<?> getAllProducts() {
        return ResponseEntity.ok(productRepo.findAll());
    }
}
