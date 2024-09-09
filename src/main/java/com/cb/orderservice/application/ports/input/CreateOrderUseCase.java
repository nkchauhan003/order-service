package com.cb.orderservice.application.ports.input;

import com.cb.orderservice.domain.model.Order;

public interface CreateOrderUseCase {
    Order createOrder(Order order);
}
