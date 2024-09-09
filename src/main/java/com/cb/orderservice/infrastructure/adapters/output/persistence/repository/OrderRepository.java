package com.cb.orderservice.infrastructure.adapters.output.persistence.repository;

import com.cb.orderservice.infrastructure.adapters.output.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
