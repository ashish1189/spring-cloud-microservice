package com.infinity.order.api.service.impl;

import com.infinity.order.api.entity.Order;
import com.infinity.order.api.model.Payment;
import com.infinity.order.api.model.TransactionRequest;
import com.infinity.order.api.model.TransactionResponse;
import com.infinity.order.api.repository.OrderRepository;
import com.infinity.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;

    private String paymentServiceUrl = "http://PAYMENT-SERVICE/api/v1/payments/make";

    @Override
    public TransactionResponse saveOrder(TransactionRequest request) {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
        //logger.info("Order-Service Request : "+new ObjectMapper().writeValueAsString(request));
        Payment paymentResponse = restTemplate.postForObject(paymentServiceUrl, payment, Payment.class);

        response = paymentResponse.getStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api , order added to cart";
        //logger.info("Order Service getting Response from Payment-Service : "+new ObjectMapper().writeValueAsString(response));
        orderRepository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }

}
