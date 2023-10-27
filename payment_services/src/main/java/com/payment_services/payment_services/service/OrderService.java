package com.payment_services.payment_services.service;

import com.payment_services.payment_services.entity.Order;
import com.payment_services.payment_services.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getUncompletedOrders() {
        return orderRepository.findByPaymentCompleted(false);
    }

    public void completePayment(Long id) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setPaymentCompleted(true);
            orderRepository.save(order);
        }
    }
}
