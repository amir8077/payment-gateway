package com.payment_services.payment_services.controller;

import com.payment_services.payment_services.entity.Order;
import com.payment_services.payment_services.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//http://localhost:8080/orders
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/uncompleted")
    public List<Order> getUncompletedOrders() {
        return orderService.getUncompletedOrders();
    }

    @PostMapping("/{id}/complete")
    public void completePayment(@PathVariable Long id) {
        orderService.completePayment(id);
    }
}
