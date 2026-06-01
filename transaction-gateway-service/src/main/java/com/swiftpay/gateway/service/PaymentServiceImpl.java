package com.swiftpay.gateway.service;

import com.swiftpay.common.enums.PaymentStatus;
import com.swiftpay.gateway.dto.PaymentRequest;
import com.swiftpay.gateway.dto.PaymentResponse;
import com.swiftpay.gateway.entity.Payment;
import com.swiftpay.gateway.producer.PaymentEventProducer;
import com.swiftpay.gateway.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl
        implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final IdempotencyService
            idempotencyService;

    private final BalanceValidationService
            balanceValidationService;

    private final PaymentEventProducer
            paymentEventProducer;

    @SuppressWarnings("null")
@Override
    public PaymentResponse processPayment(
            PaymentRequest request
    ) {

        if (idempotencyService.isDuplicate(
                request.getTransactionId())) {

            throw new RuntimeException(
                    "Transaction already processed"
            );
        }

        if (!balanceValidationService
                .hasSufficientBalance(
                        request.getSenderId(),
                        request.getAmount())) {

            throw new RuntimeException(
                    "Insufficient Funds"
            );
        }

        Payment payment =
                Payment.builder()
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

        paymentRepository.save(payment);

        idempotencyService.saveTransaction(
                request.getTransactionId()
        );

        paymentEventProducer.publishPayment(
                payment
        );

        return PaymentResponse.builder()
                .transactionId(
                        payment.getTransactionId())
                .status(
                        payment.getStatus())
                .message(
                        "Payment accepted"
                )
                .build();
    }
}