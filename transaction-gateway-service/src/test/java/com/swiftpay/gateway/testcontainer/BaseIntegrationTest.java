package com.swiftpay.gateway.testcontainer;

import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
public abstract class BaseIntegrationTest {

    @SuppressWarnings("resource")
@Container
    public
    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:16")
                    .withDatabaseName("swiftpay")
                    .withUsername("postgres")
                    .withPassword("postgres");

    @SuppressWarnings("deprecation")
@Container
    protected
    static KafkaContainer kafka =
            new KafkaContainer(
                    "confluentinc/cp-kafka:7.7.0"
            );

    @SuppressWarnings("resource")
@Container
    protected
    static GenericContainer<?> redis =
            new GenericContainer<>("redis:7")
                    .withExposedPorts(6379);
}