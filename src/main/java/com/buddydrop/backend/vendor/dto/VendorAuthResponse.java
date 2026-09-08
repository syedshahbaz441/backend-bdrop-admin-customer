package com.buddydrop.backend.vendor.dto;

public record VendorAuthResponse(String token, String role, String vendorId, String email, String name) {
}
