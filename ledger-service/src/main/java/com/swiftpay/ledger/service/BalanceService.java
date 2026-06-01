package com.swiftpay.ledger.service;

import java.math.BigDecimal;

public interface BalanceService {

    BigDecimal getBalance(Long userId);
}