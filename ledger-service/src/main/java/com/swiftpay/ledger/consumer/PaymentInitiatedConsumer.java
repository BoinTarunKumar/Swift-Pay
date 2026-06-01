package com.swiftpay.ledger.consumer;

import com.swiftpay.common.constants.KafkaTopics;
import com.swiftpay.common.event.PaymentInitiatedEvent;
import com.swiftpay.ledger.service.LedgerService;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentInitiatedConsumer {

    private final LedgerService ledgerService;

    @KafkaListener(
            topics =
                    KafkaTopics.PAYMENT_INITIATED,
            groupId = "ledger-group"
    )
    public void consume(
            PaymentInitiatedEvent event) {

        ledgerService.processPayment(
                event);
    }
}