package com.ecom.CustomerOrder.controller;


import com.ecom.CustomerOrder.model.Order;
import com.ecom.CustomerOrder.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000") // Allows React to call this API

@RestController

@Tag(name = "Order API", description = "Operations related to orders")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        System.out.println("Received order: " + order);
        Order savedOrder = service.addOrder(order);
        System.out.println("Saved order with ID: " + savedOrder.getId());
        return savedOrder;
    }

    @PostMapping("/bulk")
    public List<Order> addOrders(@RequestBody List<Order> orders) {
        System.out.println("Received orders: " + orders);
        return service.addOrders(orders);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }
}

