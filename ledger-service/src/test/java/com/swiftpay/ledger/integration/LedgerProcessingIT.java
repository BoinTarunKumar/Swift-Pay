package com.swiftpay.ledger.integration;

import com.swiftpay.ledger.testcontainer.BaseIntegrationTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LedgerProcessingIT
        extends BaseIntegrationTest {

    @Test
    void shouldStartContainers() {

        assertTrue(
                POSTGRES.isRunning()
        );

        assertTrue(
                KAFKA.isRunning()
        );
    }
}