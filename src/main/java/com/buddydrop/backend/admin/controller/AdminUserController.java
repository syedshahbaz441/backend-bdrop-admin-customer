package com.buddydrop.backend.admin.controller;

import com.buddydrop.backend.admin.dto.AdminUserCreateRequest;
import com.buddydrop.backend.admin.dto.AdminUserResponse;
import com.buddydrop.backend.admin.service.AdminUserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/users")
public class AdminUserController {

    private final AdminUserService adminUserService;

    public AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @GetMapping
    public List<AdminUserResponse> getAllUsers() {
        return adminUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminUserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(adminUserService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<AdminUserResponse> createUser(@RequestBody AdminUserCreateRequest request) {
        return ResponseEntity.ok(adminUserService.createUser(request));
    }
}
