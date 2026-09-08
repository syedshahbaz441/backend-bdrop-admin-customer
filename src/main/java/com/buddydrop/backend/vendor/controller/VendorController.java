package com.buddydrop.backend.vendor.controller;

import com.buddydrop.backend.vendor.dto.VendorAuthRequest;
import com.buddydrop.backend.vendor.dto.VendorAuthResponse;
import com.buddydrop.backend.vendor.dto.VendorDashboardResponse;
import com.buddydrop.backend.vendor.dto.VendorOrderResponse;
import com.buddydrop.backend.vendor.dto.VendorProductResponse;
import com.buddydrop.backend.vendor.service.VendorService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/login")
    public ResponseEntity<VendorAuthResponse> login(@RequestBody VendorAuthRequest request) {
        return ResponseEntity.ok(vendorService.login(request));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<VendorDashboardResponse> getDashboard() {
        return ResponseEntity.ok(vendorService.getDashboard());
    }

    @GetMapping("/products")
    public List<VendorProductResponse> getProducts() {
        return vendorService.getProducts();
    }

    @GetMapping("/orders")
    public List<VendorOrderResponse> getOrders() {
        return vendorService.getOrders();
    }
}
