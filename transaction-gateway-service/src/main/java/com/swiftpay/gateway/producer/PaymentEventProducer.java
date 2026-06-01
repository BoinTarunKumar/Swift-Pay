package com.swiftpay.gateway.producer;

import com.swiftpay.common.constants.KafkaTopics;
import com.swiftpay.common.event.PaymentInitiatedEvent;
import com.swiftpay.gateway.entity.Payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentEventProducer {

    private final KafkaTemplate<String, Object>
            kafkaTemplate;

    @SuppressWarnings("null")
public void publishPayment(
            Payment payment
    ) {

        PaymentInitiatedEvent event =
                new PaymentInitiatedEvent();

        event.setEventId(
                UUID.randomUUID().toString());

        event.setTransactionId(
                payment.getTransactionId());

        event.setSenderId(
                payment.getSenderId());

        event.setReceiverId(
                payment.getReceiverId());

        event.setAmount(
                payment.getAmount());

        event.setCurrency(
                payment.getCurrency());

        event.setEventTime(
                LocalDateTime.now());

        event.setSource(
                "transaction-gateway-service");

        kafkaTemplate.send(
                KafkaTopics.PAYMENT_INITIATED,
                payment.getTransactionId(),
                event
        );

        log.info(
                "Published PaymentInitiatedEvent : {}",
                payment.getTransactionId()
        );
    }
}