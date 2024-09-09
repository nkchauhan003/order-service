package com.cb.orderservice.domain.model;

import lombok.Getter;

import java.util.List;

// Order Aggregate Root
@Getter
public class Order {
    private Long id;
    private List<OrderItem> items;
    private OrderStatus status;

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void processOrder() {
        this.status = OrderStatus.PROCESSING;
    }
}
