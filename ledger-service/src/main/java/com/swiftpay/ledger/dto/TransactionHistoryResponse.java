package com.swiftpay.ledger.dto;

import com.swiftpay.common.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistoryResponse {

    private String transactionId;

    private Long senderId;

    private Long receiverId;

    private BigDecimal amount;

    private PaymentStatus status;

    private LocalDateTime transactionDate;
}