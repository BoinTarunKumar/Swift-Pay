package com.swiftpay.gateway.mapper;

import com.swiftpay.common.enums.PaymentStatus;
import com.swiftpay.gateway.dto.PaymentRequest;
import com.swiftpay.gateway.entity.Payment;

import java.time.LocalDateTime;

public final class PaymentMapper {

    private PaymentMapper() {
    }

    public static Payment toEntity(
            PaymentRequest request
    ) {

        return Payment.builder()
                .transactionId(
                        request.getTransactionId())
                .senderId(
                        request.getSenderId())
                .receiverId(
                        request.getReceiverId())
                .amount(
                        request.getAmount())
                .currency(
                        request.getCurrency())
                .status(
                        PaymentStatus.PENDING)
                .createdAt(
                        LocalDateTime.now())
                .updatedAt(
                        LocalDateTime.now())
                .build();
    }
}