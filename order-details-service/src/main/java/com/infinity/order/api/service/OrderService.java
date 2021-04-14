package com.infinity.order.api.service;

import com.infinity.order.api.entity.Order;
import com.infinity.order.api.model.TransactionRequest;
import com.infinity.order.api.model.TransactionResponse;

public interface OrderService {
    TransactionResponse saveOrder(TransactionRequest request);
}
