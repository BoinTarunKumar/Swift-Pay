package com.swiftpay.ledger.controller;

import com.swiftpay.ledger.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/ledger")
@RequiredArgsConstructor
public class LedgerController {

    private final BalanceService balanceService;

    @GetMapping("/balance/{userId}")
    public BigDecimal getBalance(
            @PathVariable Long userId) {

        return balanceService
                .getBalance(userId);
    }
}