package com.cb.orderservice.infrastructure.adapters.output.persistence.mapper;

import com.cb.orderservice.domain.model.Order;
import com.cb.orderservice.domain.model.OrderItem;
import com.cb.orderservice.domain.model.OrderStatus;
import com.cb.orderservice.infrastructure.adapters.output.persistence.entity.OrderEntity;
import com.cb.orderservice.infrastructure.adapters.output.persistence.entity.OrderItemEntity;
import com.cb.orderservice.infrastructure.adapters.output.persistence.entity.OrderStatusEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderEntity toEntity(Order order) {
        var orderItemEntities = order.getItems().stream()
                .map(orderItem -> new OrderItemEntity(orderItem.getProductId(), orderItem.getQuantity(), null)).toList();
        return new OrderEntity(order.getId(), orderItemEntities, OrderStatusEntity.valueOf(order.getStatus().name()));
    }

    public Order toDomain(OrderEntity orderEntity) {
        var orderItem = orderEntity.getItems().stream()
                .map(orderItemEntity -> new OrderItem(orderItemEntity.getProductId(), orderItemEntity.getQuantity())).toList();
        return new Order(orderEntity.getId(), orderItem, OrderStatus.valueOf(orderEntity.getStatus().name()));
    }
}