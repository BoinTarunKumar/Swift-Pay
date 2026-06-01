package com.swiftpay.gateway.service;

import com.swiftpay.gateway.dto.PaymentRequest;
import com.swiftpay.gateway.dto.PaymentResponse;

public interface PaymentService {

    PaymentResponse processPayment(
            PaymentRequest request
    );
}