package com.buddydrop.backend.customer.dto;

public record CustomerOrderCreateRequest(
        String service,
        String pickupLocation,
        String dropoffLocation,
        String orderDate,
        String pickupTime,
        Double totalAmount
) {
}
