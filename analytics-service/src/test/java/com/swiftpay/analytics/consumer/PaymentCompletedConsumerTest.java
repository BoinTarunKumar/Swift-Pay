package com.swiftpay.analytics.consumer;

import com.swiftpay.analytics.service.AnalyticsService;
import com.swiftpay.common.event.PaymentCompletedEvent;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaymentCompletedConsumerTest {

    @Mock
    private AnalyticsService analyticsService;

    @InjectMocks
    private PaymentCompletedConsumer consumer;

    @Test
    void shouldInvokeAnalyticsService() {

        PaymentCompletedEvent event =
                new PaymentCompletedEvent();

        event.setTransactionId(
                "TXN-1001"
        );

        consumer.consume(
                event
        );

        verify(analyticsService)
                .saveAnalytics(
                        event
                );
    }
}