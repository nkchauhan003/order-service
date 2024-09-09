package com.cb.orderservice.infrastructure.adapters.output.persistence;

import com.cb.orderservice.application.ports.output.OrderOutputPort;
import com.cb.orderservice.domain.model.Order;
import com.cb.orderservice.infrastructure.adapters.output.persistence.entity.OrderEntity;
import com.cb.orderservice.infrastructure.adapters.output.persistence.mapper.OrderMapper;
import com.cb.orderservice.infrastructure.adapters.output.persistence.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderPersistenceAdapter implements OrderOutputPort {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderPersistenceAdapter(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = orderMapper.toEntity(order);
        OrderEntity savedEntity = orderRepository.save(orderEntity);
        return orderMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Order> findById(Long orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::toDomain);
    }
}
