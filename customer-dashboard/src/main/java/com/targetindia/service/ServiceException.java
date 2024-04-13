package com.targetindia.service;

public class ServiceException extends RuntimeException{
    public ServiceException() {
        super("Service exception");
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
