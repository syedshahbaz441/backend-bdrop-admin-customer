package com.buddydrop.backend.vendor.dto;

public record VendorOrderResponse(
        Long id,
        String customerName,
        String itemName,
        Double total,
        String status,
        String createdAt
) {
}
