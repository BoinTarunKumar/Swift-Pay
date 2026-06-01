package com.swiftpay.gateway.service;

import java.math.BigDecimal;

public interface BalanceValidationService {

    boolean hasSufficientBalance(
            Long senderId,
            BigDecimal amount
    );
}