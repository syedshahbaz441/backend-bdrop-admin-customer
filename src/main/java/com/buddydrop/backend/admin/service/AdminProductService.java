package com.buddydrop.backend.admin.service;

import com.buddydrop.backend.admin.dto.AdminProductCreateRequest;
import com.buddydrop.backend.admin.dto.AdminProductResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdminProductService {

    public List<AdminProductResponse> getAllProducts() {
        return List.of(
            new AdminProductResponse(1L, "Laptop", "Electronics", 1200.00),
            new AdminProductResponse(2L, "Shoe", "Fashion", 80.00)
        );
    }

    public AdminProductResponse getProductById(Long id) {
        return new AdminProductResponse(id, "Product-" + id, "Category-" + id, 99.99);
    }

    public AdminProductResponse createProduct(AdminProductCreateRequest request) {
        return new AdminProductResponse(100L, request.name(), request.category(), request.price());
    }
}
