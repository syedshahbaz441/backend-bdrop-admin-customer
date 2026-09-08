package com.buddydrop.backend.auth;

import com.buddydrop.backend.admin.service.AdminUserService;
import com.buddydrop.backend.customer.service.CustomerProfileService;
import com.buddydrop.backend.driver.service.DriverService;
import com.buddydrop.backend.vendor.service.VendorService;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/customer/login")
    public ResponseEntity<Map<String, Object>> customerLogin(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");
        String location = payload.getOrDefault("location", "Downtown");

        if (email == null || password == null || !email.contains("@") || !password.equals("demo123")) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid customer credentials"));
        }

        return ResponseEntity.ok(Map.of(
            "token", "customer-token-demo",
            "user", Map.of(
                "id", 1,
                "name", "Ava Carter",
                "email", email,
                "location", location
            )
        ));
    }

    @PostMapping("/admin/login")
    public ResponseEntity<Map<String, Object>> adminLogin(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");

        if (username == null || password == null) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid admin credentials"));
        }

        String role = switch (username) {
            case "admin" -> password.equals("admin123") ? "admin" : null;
            case "manager" -> password.equals("manager123") ? "manager" : null;
            case "viewer" -> password.equals("viewer123") ? "viewer" : null;
            default -> null;
        };

        if (role == null) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid admin credentials"));
        }

        return ResponseEntity.ok(Map.of(
            "token", "admin-token-demo",
            "role", role,
            "username", username,
            "name", username
        ));
    }

    @PostMapping("/vendor/login")
    public ResponseEntity<Map<String, Object>> vendorLogin(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");

        if (email == null || password == null || !email.contains("@") || !password.equals("vendor123")) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid vendor credentials"));
        }

        return ResponseEntity.ok(Map.of(
            "token", "vendor-token-demo",
            "role", "VENDOR",
            "vendorId", "vendor-101",
            "email", email,
            "name", "FreshBite Kitchen"
        ));
    }

    @PostMapping("/driver/login")
    public ResponseEntity<Map<String, Object>> driverLogin(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");

        if (email == null || password == null || !email.contains("@") || !password.equals("Password123")) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid driver credentials"));
        }

        return ResponseEntity.ok(Map.of(
            "token", "driver-token-demo",
            "role", "DRIVER",
            "driverId", "driver-201",
            "email", email,
            "name", "Daniel Ross"
        ));
    }
}
