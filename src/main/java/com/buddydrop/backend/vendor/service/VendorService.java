package com.buddydrop.backend.vendor.service;

import com.buddydrop.backend.vendor.dto.VendorAuthRequest;
import com.buddydrop.backend.vendor.dto.VendorAuthResponse;
import com.buddydrop.backend.vendor.dto.VendorDashboardResponse;
import com.buddydrop.backend.vendor.dto.VendorOrderResponse;
import com.buddydrop.backend.vendor.dto.VendorProductResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    public VendorAuthResponse login(VendorAuthRequest request) {
        if (request.email() == null || request.password() == null) {
            throw new IllegalArgumentException("Email and password are required");
        }

        return new VendorAuthResponse(
                "vendor-token-123",
                "VENDOR",
                "vendor-101",
                request.email(),
                "FreshBite Kitchen"
        );
    }

    public VendorDashboardResponse getDashboard() {
        return new VendorDashboardResponse(1240.0, 86, 42, 4.9);
    }

    public List<VendorProductResponse> getProducts() {
        return List.of(
                new VendorProductResponse(1L, "Classic Burger", "Signature grilled burger with cheddar.", 18.0, 22, "Burgers", true),
                new VendorProductResponse(2L, "Veggie Wrap", "Fresh veggies, hummus, and herbs.", 15.0, 17, "Wraps", true),
                new VendorProductResponse(3L, "Chickpea Bowl", "Healthy grains and roasted chickpeas.", 17.0, 14, "Bowls", true)
        );
    }

    public List<VendorOrderResponse> getOrders() {
        return List.of(
                new VendorOrderResponse(1042L, "John Carter", "Classic Burger", 18.0, "READY", "2026-09-09T12:15:00"),
                new VendorOrderResponse(1043L, "Aisha Khan", "Veggie Wrap", 15.0, "PREPARING", "2026-09-09T12:30:00"),
                new VendorOrderResponse(1044L, "Michael Lee", "Chickpea Bowl", 17.0, "NEW", "2026-09-09T12:48:00")
        );
    }
}
