package com.buddydrop.backend.customer.service;

import com.buddydrop.backend.customer.dto.CustomerOrderCreateRequest;
import com.buddydrop.backend.customer.dto.CustomerOrderResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {

    private final List<CustomerOrderResponse> orders = List.of(
            new CustomerOrderResponse(
                    1L,
                    "Bike courier",
                    "On the way",
                    "Riverside Market",
                    "City Hall",
                    "Today",
                    "4:30 PM",
                    "5:15 PM",
                    22.50,
                    68
            ),
            new CustomerOrderResponse(
                    2L,
                    "Same-day delivery",
                    "Pickup confirmed",
                    "Harbor Road",
                    "Elm Street",
                    "Yesterday",
                    "11:10 AM",
                    "12:00 PM",
                    18.00,
                    42
            ),
            new CustomerOrderResponse(
                    3L,
                    "Package transfer",
                    "Delivered",
                    "Bayside",
                    "North End",
                    "Mon",
                    "9:45 AM",
                    "Delivered",
                    15.80,
                    100
            )
    );

    public List<CustomerOrderResponse> getOrders() {
        return orders;
    }

    public CustomerOrderResponse getActiveOrder() {
        return orders.getFirst();
    }

    public CustomerOrderResponse getOrderById(Long id) {
        return orders.stream()
                .filter(order -> order.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + id));
    }

    public CustomerOrderResponse createOrder(CustomerOrderCreateRequest request) {
        long nextId = orders.size() + 10L;
        var created = new CustomerOrderResponse(
                nextId,
                request.service(),
                "Order placed",
                request.pickupLocation(),
                request.dropoffLocation(),
                request.orderDate(),
                request.pickupTime(),
                "Awaiting driver",
                request.totalAmount(),
                15
        );

        return created;
    }
}
