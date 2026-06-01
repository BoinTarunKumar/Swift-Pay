package com.swiftpay.gateway.integration;

import com.swiftpay.gateway.testcontainer.BaseIntegrationTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KafkaIntegrationIT
        extends BaseIntegrationTest {

    @Test
    void kafkaContainerShouldStart() {

        assertTrue(
                kafka.isRunning());
    }
}