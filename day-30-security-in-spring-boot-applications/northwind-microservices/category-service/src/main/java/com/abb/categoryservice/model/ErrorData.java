package com.abb.categoryservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorData {
    private String message;
    private Date timestamp = new Date();

    public ErrorData(String message) {
        this.message = message;
    }
}
