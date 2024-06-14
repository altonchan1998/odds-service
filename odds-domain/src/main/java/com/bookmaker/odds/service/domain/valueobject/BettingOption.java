package com.bookmaker.odds.service.domain.valueobject;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BettingOption {
    private final String code;
    private Odds odds;
    private Probability probability;

    public BettingOption(String code, Odds odds, Probability probability) {
        this.code = code;
        this.odds = odds;
        this.probability = probability;
    }
}
