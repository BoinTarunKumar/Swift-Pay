package com.swiftpay.ledger.service;

import com.swiftpay.ledger.entity.Account;
import com.swiftpay.ledger.repository.AccountRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BalanceServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private BalanceServiceImpl balanceService;

    @Test
    void shouldReturnBalance() {

        Account account =
                Account.builder()
                        .userId(101L)
                        .balance(
                                BigDecimal.valueOf(5000))
                        .currency("INR")
                        .build();

        when(accountRepository.findByUserId(101L))
                .thenReturn(Optional.of(account));

        BigDecimal balance =
                balanceService.getBalance(101L);

        assertEquals(
                BigDecimal.valueOf(5000),
                balance
        );
    }
}