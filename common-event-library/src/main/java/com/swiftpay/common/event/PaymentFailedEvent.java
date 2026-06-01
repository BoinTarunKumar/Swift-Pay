package com.swiftpay.common.event;

import com.swiftpay.common.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentFailedEvent extends BaseEvent {

    private PaymentStatus status;

    private String failureReason;

}