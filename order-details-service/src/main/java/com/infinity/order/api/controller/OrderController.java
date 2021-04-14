package com.infinity.order.api.controller;

import com.infinity.order.api.model.TransactionRequest;
import com.infinity.order.api.model.TransactionResponse;
import com.infinity.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/book")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest order) {
        return orderService.saveOrder(order);
    }
}
