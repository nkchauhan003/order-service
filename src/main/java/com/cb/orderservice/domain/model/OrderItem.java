package com.cb.orderservice.domain.model;

import lombok.Getter;
import lombok.Setter;

// OrderItem Entity
@Getter
@Setter
public class OrderItem {
    private Long productId;
    private int quantity;
}
