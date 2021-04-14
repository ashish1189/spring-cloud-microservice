package com.infinity.payment.api.controller;

import com.infinity.payment.api.entity.Payment;
import com.infinity.payment.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/make")
    public Payment makePayment(@RequestBody Payment payment) {
        return paymentService.makePayment(payment);
    }

    @GetMapping(value = "/{orderId}")
    public Payment getPaymentByOrder(@PathVariable int orderId) {
        return paymentService.getPaymentByOrder(orderId);
    }
}
