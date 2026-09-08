package com.buddydrop.backend.vendor.dto;

public record VendorDashboardResponse(
        Double salesToday,
        Integer ordersToday,
        Integer activeItems,
        Double rating
) {
}
