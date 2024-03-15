package com.neo.payment.ms.repository;

import com.neo.payment.ms.entity.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    Optional<Payment> findByOrderId(long orderId);
}
