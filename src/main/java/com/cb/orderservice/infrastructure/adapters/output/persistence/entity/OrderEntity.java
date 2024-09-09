package com.cb.orderservice.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "orderEntity")
    private List<OrderItemEntity> items;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatusEntity status;
}
