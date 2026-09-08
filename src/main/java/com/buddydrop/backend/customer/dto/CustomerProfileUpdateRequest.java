package com.buddydrop.backend.customer.dto;

public record CustomerProfileUpdateRequest(
        String firstName,
        String lastName,
        String email,
        String phone,
        String city
) {
}
