package com.bookmaker.odds.service.domain.exception;

public class OddsDomainException extends DomainException {
    public OddsDomainException(String message) {
        super(message);
    }

    public OddsDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
