package com.cb.orderservice.domain.service;

import com.cb.orderservice.application.ports.input.CreateOrderUseCase;
import com.cb.orderservice.application.ports.input.GetOrderUseCase;
import com.cb.orderservice.application.ports.output.InventoryOutputPort;
import com.cb.orderservice.application.ports.output.OrderOutputPort;
import com.cb.orderservice.domain.model.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements CreateOrderUseCase, GetOrderUseCase {

    private final OrderOutputPort orderOutputPort;
    private final InventoryOutputPort inventoryOutputPort;

    public OrderService(OrderOutputPort orderOutputPort, InventoryOutputPort inventoryOutputPort) {
        this.orderOutputPort = orderOutputPort;
        this.inventoryOutputPort = inventoryOutputPort;
    }

    @Override
    public Order createOrder(Order order) {
        // Check inventory before creating the order
        order.getItems().forEach(orderItem -> {
            boolean isAvailable = inventoryOutputPort.checkInventory(orderItem.getProductId(), orderItem.getQuantity());

            if (!isAvailable) {
                throw new RuntimeException("Insufficient inventory for product: " + orderItem.getProductId());
            }
        });
        // Proceed to create order if inventory is sufficient
        return orderOutputPort.save(order);
    }

    @Override
    public Optional<Order> getOrder(Long orderId) {
        return orderOutputPort.findById(orderId);
    }
}
