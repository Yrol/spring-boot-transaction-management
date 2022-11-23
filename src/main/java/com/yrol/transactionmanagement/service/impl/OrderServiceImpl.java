package com.yrol.transactionmanagement.service.impl;

import com.yrol.transactionmanagement.dto.OrderRequest;
import com.yrol.transactionmanagement.dto.OrderResponse;
import com.yrol.transactionmanagement.entity.Order;
import com.yrol.transactionmanagement.entity.Payment;
import com.yrol.transactionmanagement.exception.PaymentException;
import com.yrol.transactionmanagement.repository.OrderRepository;
import com.yrol.transactionmanagement.repository.PaymentRepository;
import com.yrol.transactionmanagement.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        // Supporting only debit card payments
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment method doesn't support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
