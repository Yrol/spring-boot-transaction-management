package com.yrol.transactionmanagement.service;

import com.yrol.transactionmanagement.dto.OrderRequest;
import com.yrol.transactionmanagement.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
