package com.cb.orderservice.infrastructure.adapters.output.persistence.entity;

public enum OrderStatusEntity {
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELED,
    RETURNED;

    // Optional: Add methods to provide more information or functionality

    public String getDescription() {
        switch (this) {
            case PENDING:
                return "Order is pending confirmation.";
            case PROCESSING:
                return "Order is being processed.";
            case SHIPPED:
                return "Order has been shipped.";
            case DELIVERED:
                return "Order has been delivered.";
            case CANCELED:
                return "Order has been canceled.";
            case RETURNED:
                return "Order has been returned.";
            default:
                return "Unknown order status.";
        }
    }
}
