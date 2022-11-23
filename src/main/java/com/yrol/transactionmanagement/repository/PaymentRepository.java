package com.yrol.transactionmanagement.repository;

import com.yrol.transactionmanagement.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
