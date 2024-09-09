package com.cb.orderservice.application.ports.output;

public interface InventoryOutputPort {
    boolean checkInventory(Long productId, int quantity);
}
