package com.bookmaker.odds.service.domain.exception;

public class InnoMatchNotFoundException extends OddsDomainException{
    public InnoMatchNotFoundException(String message) {
        super(message);
    }

    public InnoMatchNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
