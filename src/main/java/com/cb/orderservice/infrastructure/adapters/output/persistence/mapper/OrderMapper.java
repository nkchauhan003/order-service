package com.cb.orderservice.infrastructure.adapters.output.persistence.mapper;

import com.cb.orderservice.domain.model.Order;
import com.cb.orderservice.infrastructure.adapters.output.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderEntity toEntity(Order order);

    Order toDomain(OrderEntity orderEntity);
}