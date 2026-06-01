package com.swiftpay.gateway.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BalanceValidationServiceImpl
        implements BalanceValidationService {

    @Override
    public boolean hasSufficientBalance(
            Long senderId,
            BigDecimal amount
    ) {

        /*
         * In real system:
         * Call Ledger Service
         * or Redis Cache
         */

        BigDecimal availableBalance =
                BigDecimal.valueOf(100000);

        return availableBalance.compareTo(amount)
                >= 0;
    }
}