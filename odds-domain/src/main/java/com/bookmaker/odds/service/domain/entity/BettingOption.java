package com.bookmaker.odds.service.domain.entity;


import lombok.Getter;
import lombok.Setter;
import com.bookmaker.odds.service.domain.valueobject.Odds;
import com.bookmaker.odds.service.domain.valueobject.Probability;
import com.bookmaker.odds.service.domain.valueobject.id.BettingOptionId;


@Setter
@Getter
public class BettingOption extends BaseEntity<BettingOptionId> {
    private final String name;
    private Odds odds;
    private Probability probability;

    public BettingOption(String name, Odds odds, Probability probability) {
        this.name = name;
        this.odds = odds;
        this.probability = probability;
    }
}
