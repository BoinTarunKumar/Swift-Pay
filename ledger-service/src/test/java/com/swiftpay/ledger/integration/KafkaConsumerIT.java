package com.swiftpay.ledger.integration;

import com.swiftpay.ledger.testcontainer.BaseIntegrationTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class KafkaConsumerIT
        extends BaseIntegrationTest {

    @Test
    void kafkaShouldBeAvailable() {

        assertTrue(
                KAFKA.isRunning()
        );
    }
}