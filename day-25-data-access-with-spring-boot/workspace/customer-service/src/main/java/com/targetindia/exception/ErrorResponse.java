package com.targetindia.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
