package com.swiftpay.ledger.controller;

import com.swiftpay.ledger.entity.PaymentRecord;
import com.swiftpay.ledger.service.TransactionHistoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ledger")
@RequiredArgsConstructor
public class TransactionHistoryController {

    private final TransactionHistoryService
            transactionHistoryService;

    @GetMapping("/history/{userId}")
    public List<PaymentRecord> history(
            @PathVariable Long userId) {

        return transactionHistoryService
                .getHistory(userId);
    }
}