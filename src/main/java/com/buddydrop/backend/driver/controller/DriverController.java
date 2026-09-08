package com.buddydrop.backend.driver.controller;

import com.buddydrop.backend.driver.dto.DriverAuthRequest;
import com.buddydrop.backend.driver.dto.DriverAuthResponse;
import com.buddydrop.backend.driver.dto.DriverDeliveryResponse;
import com.buddydrop.backend.driver.service.DriverService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/login")
    public ResponseEntity<DriverAuthResponse> login(@RequestBody DriverAuthRequest request) {
        return ResponseEntity.ok(driverService.login(request));
    }

    @GetMapping("/deliveries")
    public List<DriverDeliveryResponse> getDeliveries() {
        return driverService.getDeliveries();
    }
}
