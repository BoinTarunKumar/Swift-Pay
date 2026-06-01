package com.swiftpay.common.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.swiftpay.common.enums.CurrencyType;
import com.swiftpay.common.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentCompletedEvent extends BaseEvent {

    private String transactionId;

    private Long senderId;

    private Long receiverId;

    private BigDecimal amount;

    private CurrencyType currency;

    private PaymentStatus status;

    private LocalDateTime completedAt;

    private String message;

}