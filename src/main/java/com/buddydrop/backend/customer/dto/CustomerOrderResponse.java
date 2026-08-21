package com.buddydrop.backend.customer.dto;

public record CustomerOrderResponse(Long id, String status, Double totalAmount) {
}
