package com.targetindia.dao;

public class DaoException extends RuntimeException{
    public DaoException() {
        super("DAO exception");
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
