package com.buddydrop.backend.customer.dto;

public record CustomerProfileResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String city
) {
}
