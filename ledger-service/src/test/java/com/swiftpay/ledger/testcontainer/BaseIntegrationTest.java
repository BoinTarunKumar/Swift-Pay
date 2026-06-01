package com.swiftpay.ledger.testcontainer;

import org.springframework.boot.test.context.SpringBootTest;

import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
public abstract class BaseIntegrationTest {

    @SuppressWarnings("resource")
@Container
    protected static final PostgreSQLContainer<?> POSTGRES =
            new PostgreSQLContainer<>("postgres:16")
                    .withDatabaseName("swiftpay")
                    .withUsername("postgres")
                    .withPassword("postgres");

    @SuppressWarnings("deprecation")
@Container
    protected static final KafkaContainer KAFKA =
            new KafkaContainer(
                    "confluentinc/cp-kafka:7.7.0"
            );
}