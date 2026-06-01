package com.swiftpay.ledger.service;

import com.swiftpay.ledger.entity.PaymentRecord;

import java.util.List;

public interface TransactionHistoryService {

    List<PaymentRecord> getHistory(Long userId);
}