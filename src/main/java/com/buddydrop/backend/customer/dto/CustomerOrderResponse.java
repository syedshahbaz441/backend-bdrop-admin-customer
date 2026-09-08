package com.buddydrop.backend.customer.dto;

public record CustomerOrderResponse(
        Long id,
        String service,
        String status,
        String pickupLocation,
        String dropoffLocation,
        String orderDate,
        String pickupTime,
        String estimatedArrival,
        Double totalAmount,
        Integer progress
) {
}
