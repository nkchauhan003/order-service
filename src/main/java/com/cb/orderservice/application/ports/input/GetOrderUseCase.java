package com.cb.orderservice.application.ports.input;

import com.cb.orderservice.domain.model.Order;

import java.util.Optional;

public interface GetOrderUseCase {
    Optional<Order> getOrder(Long orderId);
}
