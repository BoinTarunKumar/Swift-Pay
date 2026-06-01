package com.swiftpay.ledger.producer;

import com.swiftpay.common.constants.KafkaTopics;
import com.swiftpay.common.enums.PaymentStatus;
import com.swiftpay.common.event.PaymentCompletedEvent;
import com.swiftpay.common.event.PaymentFailedEvent;
import com.swiftpay.common.event.PaymentInitiatedEvent;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStatusProducer {

    private final KafkaTemplate<String,Object>
            kafkaTemplate;

    public void publishCompletedEvent(
            PaymentInitiatedEvent source) {

        PaymentCompletedEvent event =
                new PaymentCompletedEvent();

        event.setTransactionId(
                source.getTransactionId());

        event.setStatus(
                PaymentStatus.COMPLETED);

        event.setMessage(
                "Payment Completed");

        kafkaTemplate.send(
                KafkaTopics.PAYMENT_COMPLETED,
                event);
    }

    public void publishFailedEvent(
            PaymentInitiatedEvent source,
            String reason) {

        PaymentFailedEvent event =
                new PaymentFailedEvent();

        event.setTransactionId(
                source.getTransactionId());

        event.setStatus(
                PaymentStatus.FAILED);

        event.setFailureReason(
                reason);

        kafkaTemplate.send(
                KafkaTopics.PAYMENT_FAILED,
                event);
    }
}