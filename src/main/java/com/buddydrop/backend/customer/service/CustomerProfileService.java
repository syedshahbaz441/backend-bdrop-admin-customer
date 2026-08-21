package com.buddydrop.backend.customer.service;

import com.buddydrop.backend.customer.dto.CustomerProfileResponse;
import com.buddydrop.backend.customer.dto.CustomerProfileUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerProfileService {

    public CustomerProfileResponse getProfile() {
        return new CustomerProfileResponse(1L, "customer", "customer@example.com", "New York");
    }

    public CustomerProfileResponse updateProfile(CustomerProfileUpdateRequest request) {
        return new CustomerProfileResponse(1L, request.firstName(), request.email(), request.city());
    }
}
