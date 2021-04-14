package com.infinity.payment.api.service;

import com.infinity.payment.api.entity.Payment;

public interface PaymentService {
    Payment makePayment(Payment payment);

    Payment getPaymentByOrder(int orderId);
}
