package com.buddydrop.backend.customer.controller;

import com.buddydrop.backend.customer.dto.CustomerProfileResponse;
import com.buddydrop.backend.customer.dto.CustomerProfileUpdateRequest;
import com.buddydrop.backend.customer.service.CustomerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer/profile")
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;

    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    @GetMapping
    public ResponseEntity<CustomerProfileResponse> getProfile() {
        return ResponseEntity.ok(customerProfileService.getProfile());
    }

    @PutMapping
    public ResponseEntity<CustomerProfileResponse> updateProfile(@RequestBody CustomerProfileUpdateRequest request) {
        return ResponseEntity.ok(customerProfileService.updateProfile(request));
    }
}
