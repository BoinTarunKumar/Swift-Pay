package com.swiftpay.common.event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseEvent {

    private String eventId;

    private String transactionId;

    private LocalDateTime eventTime;

    private String source;

}