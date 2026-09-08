package com.buddydrop.backend.driver.service;

import com.buddydrop.backend.driver.dto.DriverAuthRequest;
import com.buddydrop.backend.driver.dto.DriverAuthResponse;
import com.buddydrop.backend.driver.dto.DriverDeliveryResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    public DriverAuthResponse login(DriverAuthRequest request) {
        if (request.email() == null || request.password() == null) {
            throw new IllegalArgumentException("Email and password are required");
        }

        return new DriverAuthResponse(
                "driver-token-123",
                "DRIVER",
                "driver-201",
                request.email(),
                "Daniel Ross"
        );
    }

    public List<DriverDeliveryResponse> getDeliveries() {
        return List.of(
                new DriverDeliveryResponse(1L, "John Carter", "FreshBite Kitchen", "Riverside Tower", "PICKED_UP", 18.5, "12 min"),
                new DriverDeliveryResponse(2L, "Aisha Khan", "FreshBite Kitchen", "Elm Street", "EN_ROUTE", 15.0, "20 min"),
                new DriverDeliveryResponse(3L, "Michael Lee", "FreshBite Kitchen", "City Hall", "ASSIGNED", 22.0, "35 min")
        );
    }
}
