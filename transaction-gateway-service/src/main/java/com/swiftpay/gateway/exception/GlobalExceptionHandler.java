package com.swiftpay.gateway.exception;

import com.swiftpay.gateway.dto.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            DuplicateTransactionException.class)
    public ResponseEntity<ErrorResponse>
    handleDuplicateTransaction(
            DuplicateTransactionException ex
    ) {

        return ResponseEntity.status(
                HttpStatus.CONFLICT)
                .body(
                        buildError(
                                HttpStatus.CONFLICT,
                                ex.getMessage()
                        )
                );
    }

    @ExceptionHandler(
            InsufficientFundsException.class)
    public ResponseEntity<ErrorResponse>
    handleInsufficientFunds(
            InsufficientFundsException ex
    ) {

        return ResponseEntity.status(
                HttpStatus.BAD_REQUEST)
                .body(
                        buildError(
                                HttpStatus.BAD_REQUEST,
                                ex.getMessage()
                        )
                );
    }

    @ExceptionHandler(
            MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse>
    handleValidation(
            MethodArgumentNotValidException ex
    ) {

        return ResponseEntity.status(
                HttpStatus.BAD_REQUEST)
                .body(
                        buildError(
                                HttpStatus.BAD_REQUEST,
                                "Validation Failed"
                        )
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>
    handleGeneric(
            Exception ex
    ) {

        return ResponseEntity.status(
                HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        buildError(
                                HttpStatus.INTERNAL_SERVER_ERROR,
                                ex.getMessage()
                        )
                );
    }

    private ErrorResponse buildError(
            HttpStatus status,
            String message
    ) {

        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message)
                .build();
    }
}