package com.jobtrack.exception;

public class UnauthorizedApplicationException extends RuntimeException{

    public UnauthorizedApplicationException(String message) {
        super(message);
    }
}
