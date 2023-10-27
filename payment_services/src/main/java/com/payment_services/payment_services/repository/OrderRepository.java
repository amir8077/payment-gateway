package com.payment_services.payment_services.repository;

import com.payment_services.payment_services.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByPaymentCompleted(boolean paymentCompleted);
}
