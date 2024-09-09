package com.cb.orderservice.application.ports.output;

import com.cb.orderservice.domain.model.Order;

import java.util.Optional;

public interface OrderOutputPort {
    Order save(Order order);

    Optional<Order> findById(Long orderId);
}
