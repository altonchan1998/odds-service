package com.bookmaker.odds.service.domain.valueobject;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Odds {
    private final BigDecimal value;

    public Odds(BigDecimal value) {
        this.value = value;
    }


    public boolean isLocked() {
        return value.equals(BigDecimal.ZERO);
    }
}
