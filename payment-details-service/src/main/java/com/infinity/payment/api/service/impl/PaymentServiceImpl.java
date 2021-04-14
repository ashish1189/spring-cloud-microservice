package com.infinity.payment.api.service.impl;

import com.infinity.payment.api.entity.Payment;
import com.infinity.payment.api.repository.PaymentRepository;
import com.infinity.payment.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment makePayment(Payment payment) {
        payment.setStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentByOrder(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    public String paymentProcessing(){
        //api should be 3rd party payment gateway (paypal,paytm...)
        return new Random().nextBoolean() ? "success" : "false";
    }
}
