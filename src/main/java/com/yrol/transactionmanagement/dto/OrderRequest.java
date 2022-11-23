package com.yrol.transactionmanagement.dto;

import com.yrol.transactionmanagement.entity.Order;
import com.yrol.transactionmanagement.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
