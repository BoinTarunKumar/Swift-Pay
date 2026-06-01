package com.swiftpay.gateway.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BalanceValidationServiceTest {

    private final BalanceValidationService service =
            new BalanceValidationServiceImpl();

    @Test
    void shouldHaveSufficientBalance() {

        boolean result =
                service.hasSufficientBalance(
                        101L,
                        BigDecimal.valueOf(100)
                );

        assertTrue(result);
    }
}