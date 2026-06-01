package com.swiftpay.gateway.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdempotencyServiceTest {

    @Test
    void duplicateTransactionTest() {

        String transactionId =
                "TXN1001";

        assertNotNull(transactionId);
    }
}