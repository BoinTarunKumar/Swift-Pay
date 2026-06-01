package com.swiftpay.ledger.mapper;

import com.swiftpay.ledger.dto.AccountBalanceResponse;
import com.swiftpay.ledger.dto.TransactionHistoryResponse;
import com.swiftpay.ledger.entity.Account;
import com.swiftpay.ledger.entity.PaymentRecord;

public final class LedgerMapper {

    private LedgerMapper() {
    }

    public static AccountBalanceResponse toBalanceResponse(
            Account account) {

        return AccountBalanceResponse
                .builder()
                .userId(account.getUserId())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .build();
    }

    public static TransactionHistoryResponse
    toHistoryResponse(
            PaymentRecord payment) {

        return TransactionHistoryResponse
                .builder()
                .transactionId(
                        payment.getTransactionId())
                .senderId(
                        payment.getSenderId())
                .receiverId(
                        payment.getReceiverId())
                .amount(
                        payment.getAmount())
                .status(
                        payment.getStatus())
                .transactionDate(
                        payment.getCreatedAt())
                .build();
    }
}