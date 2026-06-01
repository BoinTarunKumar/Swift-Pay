package com.swiftpay.gateway.service;

public interface IdempotencyService {

    boolean isDuplicate(
            String transactionId
    );

    void saveTransaction(
            String transactionId
    );
}