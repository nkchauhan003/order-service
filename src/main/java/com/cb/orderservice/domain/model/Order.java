package com.cb.orderservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private Long id;
    private List<OrderItem> items;
    private OrderStatus status;
}
