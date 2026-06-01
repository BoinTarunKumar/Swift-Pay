package com.swiftpay.gateway.dto;

import com.swiftpay.common.enums.CurrencyType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {

    @NotBlank
    private String transactionId;

    @NotNull
    private Long senderId;

    @NotNull
    private Long receiverId;

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal amount;

    @NotNull
    private CurrencyType currency;
}