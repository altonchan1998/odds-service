package com.bookmaker.odds.service.domain.entity;

import lombok.Getter;
import com.bookmaker.odds.service.domain.enums.MarketType;
import com.bookmaker.odds.service.domain.valueobject.id.MarketId;

import java.util.List;

@Getter
public class Market extends AggregateRoot<MarketId> {
    private final String code;
    private final Match match;
    private final MarketType marketType;
    private final List<BettingOption> bettingOptions;

    public Market(String code, Match match, MarketType marketType, List<BettingOption> bettingOptions) {
        this.code = code;
        this.match = match;
        this.marketType = marketType;
        this.bettingOptions = bettingOptions;
    }
}
