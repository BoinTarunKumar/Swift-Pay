package com.swiftpay.ledger.consumer;

import com.swiftpay.common.event.PaymentInitiatedEvent;
import com.swiftpay.ledger.service.LedgerService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaymentInitiatedConsumerTest {

    @Mock
    private LedgerService ledgerService;

    @InjectMocks
    private PaymentInitiatedConsumer consumer;

    @Test
    void shouldInvokeLedgerService() {

        PaymentInitiatedEvent event =
                new PaymentInitiatedEvent();

        event.setTransactionId("TXN-1001");

        consumer.consume(event);

        verify(ledgerService)
                .processPayment(event);
    }
}