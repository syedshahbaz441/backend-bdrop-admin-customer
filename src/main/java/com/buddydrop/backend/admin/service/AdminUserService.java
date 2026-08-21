package com.buddydrop.backend.admin.service;

import com.buddydrop.backend.admin.dto.AdminUserCreateRequest;
import com.buddydrop.backend.admin.dto.AdminUserResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {

    public List<AdminUserResponse> getAllUsers() {
        return List.of(
            new AdminUserResponse(1L, "admin", "admin@example.com"),
            new AdminUserResponse(2L, "manager", "manager@example.com")
        );
    }

    public AdminUserResponse getUserById(Long id) {
        return new AdminUserResponse(id, "user-" + id, "user" + id + "@example.com");
    }

    public AdminUserResponse createUser(AdminUserCreateRequest request) {
        return new AdminUserResponse(100L, request.username(), request.email());
    }
}
