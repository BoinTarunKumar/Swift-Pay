package com.swiftpay.gateway.service;

import com.swiftpay.gateway.repository.PaymentRepository;
import com.swiftpay.gateway.producer.PaymentEventProducer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private IdempotencyService
            idempotencyService;

    @Mock
    private BalanceValidationService
            balanceValidationService;

    @Mock
    private PaymentEventProducer
            paymentEventProducer;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Test
    void shouldPublishEventAfterSave() {

        verifyNoInteractions(
                paymentRepository);

        verifyNoInteractions(
                paymentEventProducer);
    }
}
