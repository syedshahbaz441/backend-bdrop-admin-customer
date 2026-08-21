package com.buddydrop.backend.customer.service;

import com.buddydrop.backend.customer.dto.CustomerOrderCreateRequest;
import com.buddydrop.backend.customer.dto.CustomerOrderResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {

    public List<CustomerOrderResponse> getOrders() {
        return List.of(
            new CustomerOrderResponse(1L, "PENDING", 1200.00),
            new CustomerOrderResponse(2L, "SHIPPED", 80.00)
        );
    }

    public CustomerOrderResponse getOrderById(Long id) {
        return new CustomerOrderResponse(id, "PROCESSING", 49.99);
    }

    public CustomerOrderResponse createOrder(CustomerOrderCreateRequest request) {
        return new CustomerOrderResponse(100L, "PENDING", request.totalAmount());
    }
}
