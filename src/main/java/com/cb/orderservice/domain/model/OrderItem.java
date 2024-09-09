package com.cb.orderservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class OrderItem {
    private Long productId;
    private int quantity;
}
