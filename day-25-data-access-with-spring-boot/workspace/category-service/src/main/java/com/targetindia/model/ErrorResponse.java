package com.targetindia.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.Date;

@Data
@JacksonXmlRootElement(localName = "error")
public class ErrorResponse {
    private String message;
    private Date timestamp = new Date();

    public ErrorResponse(String message) {
        this.message = message;
    }
}
