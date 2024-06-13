package com.bookmaker.odds.service.domain.valueobject;

import java.math.BigDecimal;

public class Probability {

    private final BigDecimal value;

    public Probability(BigDecimal value) {
        this.value = value;
    }
}
