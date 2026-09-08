package com.buddydrop.backend.driver.dto;

public record DriverDeliveryResponse(
        Long id,
        String customerName,
        String pickupLocation,
        String dropoffLocation,
        String status,
        Double earnings,
        String eta
) {
}
