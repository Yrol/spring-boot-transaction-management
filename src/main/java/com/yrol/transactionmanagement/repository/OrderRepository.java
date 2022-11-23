package com.yrol.transactionmanagement.repository;

import com.yrol.transactionmanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
