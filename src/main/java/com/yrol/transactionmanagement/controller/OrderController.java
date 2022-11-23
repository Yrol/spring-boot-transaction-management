package com.yrol.transactionmanagement.controller;

import com.yrol.transactionmanagement.dto.OrderRequest;
import com.yrol.transactionmanagement.dto.OrderResponse;
import com.yrol.transactionmanagement.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest request){
        return ResponseEntity.ok(orderService.placeOrder(request));
    }
}
