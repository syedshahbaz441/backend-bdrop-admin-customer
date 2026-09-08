package com.buddydrop.backend.driver.dto;

public record DriverAuthResponse(String token, String role, String driverId, String email, String name) {
}
