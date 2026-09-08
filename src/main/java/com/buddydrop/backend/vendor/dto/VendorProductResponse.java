package com.buddydrop.backend.vendor.dto;

public record VendorProductResponse(
        Long id,
        String name,
        String description,
        Double price,
        Integer stock,
        String category,
        Boolean isAvailable
) {
}
