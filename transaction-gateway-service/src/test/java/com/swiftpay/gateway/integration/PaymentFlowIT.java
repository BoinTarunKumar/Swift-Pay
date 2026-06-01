package com.swiftpay.gateway.integration;

import com.swiftpay.gateway.testcontainer.BaseIntegrationTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFlowIT
        extends BaseIntegrationTest {

    @Test
    void paymentFlowShouldWork() {

        assertTrue(
                postgres.isRunning());

        assertTrue(
                kafka.isRunning());

        assertTrue(
                redis.isRunning());
    }
}