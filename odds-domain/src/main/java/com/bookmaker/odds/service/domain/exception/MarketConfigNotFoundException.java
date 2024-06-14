package com.bookmaker.odds.service.domain.exception;

public class MarketConfigNotFoundException extends OddsDomainException{
    public MarketConfigNotFoundException(String message) {
        super(message);
    }

    public MarketConfigNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
