package com.swiftpay.common.event;

import com.swiftpay.common.enums.CurrencyType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentInitiatedEvent extends BaseEvent {

    private Long senderId;

    private Long receiverId;

    private BigDecimal amount;

    private CurrencyType currency;

}