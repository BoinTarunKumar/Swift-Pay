package com.swiftpay.ledger.service;

import com.swiftpay.ledger.entity.Account;
import com.swiftpay.ledger.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl
        implements BalanceService {

    private final AccountRepository accountRepository;

    @Override
    public BigDecimal getBalance(Long userId) {

        Account account =
                accountRepository.findByUserId(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Account not found"));

        return account.getBalance();
    }
}