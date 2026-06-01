package com.swiftpay.analytics.consumer;

import com.swiftpay.analytics.service.AnalyticsService;
import com.swiftpay.common.constants.KafkaTopics;
import com.swiftpay.common.event.PaymentCompletedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentCompletedConsumer {

    private final AnalyticsService analyticsService;

    @KafkaListener(
            topics = KafkaTopics.PAYMENT_COMPLETED,
            groupId = "analytics-group"
    )
    public void consume(
            PaymentCompletedEvent event
    ) {

        log.info(
                "Received PaymentCompletedEvent : {}",
                event.getTransactionId()
        );

        analyticsService.saveAnalytics(
                event
        );
    }
}