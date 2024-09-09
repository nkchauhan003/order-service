package com.cb.orderservice.infrastructure.adapters.output.client;


import com.cb.orderservice.application.ports.output.InventoryOutputPort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InventoryRestAdapter implements InventoryOutputPort {

    private final RestTemplate restTemplate;

    public InventoryRestAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean checkInventory(Long productId, int quantity) {
       /* String url = "http://inventory-service/api/inventory/check?productId=" + productId + "&quantity=" + quantity;
        var available = restTemplate.getForObject(url, Boolean.class);*/
        var available = true; // Dummy value
        return available;
    }
}
