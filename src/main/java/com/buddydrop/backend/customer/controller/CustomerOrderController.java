package com.buddydrop.backend.customer.controller;

import com.buddydrop.backend.customer.dto.CustomerOrderCreateRequest;
import com.buddydrop.backend.customer.dto.CustomerOrderResponse;
import com.buddydrop.backend.customer.service.CustomerOrderService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @GetMapping("/orders")
    public List<CustomerOrderResponse> getOrders() {
        return customerOrderService.getOrders();
    }

    @GetMapping("/orders/active")
    public ResponseEntity<CustomerOrderResponse> getActiveOrder() {
        return ResponseEntity.ok(customerOrderService.getActiveOrder());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<CustomerOrderResponse> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(customerOrderService.getOrderById(id));
    }

    @PostMapping("/orders")
    public ResponseEntity<CustomerOrderResponse> createOrder(@RequestBody CustomerOrderCreateRequest request) {
        return ResponseEntity.ok(customerOrderService.createOrder(request));
    }
}
