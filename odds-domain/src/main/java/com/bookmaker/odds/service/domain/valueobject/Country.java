package com.bookmaker.odds.service.domain.valueobject;


import lombok.Getter;

@Getter
public class Country {
    private final String countryCode;

    public Country(String countryCode) {
        this.countryCode = countryCode;
    }
}
