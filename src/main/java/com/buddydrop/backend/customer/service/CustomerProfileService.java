package com.buddydrop.backend.customer.service;

import com.buddydrop.backend.customer.dto.CustomerProfileResponse;
import com.buddydrop.backend.customer.dto.CustomerProfileUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerProfileService {

    public CustomerProfileResponse getProfile() {
        return new CustomerProfileResponse(
                1L,
                "Olivia",
                "Carter",
                "olivia@buddydrop.com",
                "+1 415 555 0170",
                "Seattle"
        );
    }

    public CustomerProfileResponse updateProfile(CustomerProfileUpdateRequest request) {
        return new CustomerProfileResponse(
                1L,
                request.firstName(),
                request.lastName(),
                request.email(),
                request.phone(),
                request.city()
        );
    }
}
