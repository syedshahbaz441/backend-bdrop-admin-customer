package com.buddydrop.backend.admin.controller;

import com.buddydrop.backend.admin.dto.AdminProductCreateRequest;
import com.buddydrop.backend.admin.dto.AdminProductResponse;
import com.buddydrop.backend.admin.service.AdminProductService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {

    private final AdminProductService adminProductService;

    public AdminProductController(AdminProductService adminProductService) {
        this.adminProductService = adminProductService;
    }

    @GetMapping
    public List<AdminProductResponse> getAllProducts() {
        return adminProductService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(adminProductService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<AdminProductResponse> createProduct(@RequestBody AdminProductCreateRequest request) {
        return ResponseEntity.ok(adminProductService.createProduct(request));
    }
}
