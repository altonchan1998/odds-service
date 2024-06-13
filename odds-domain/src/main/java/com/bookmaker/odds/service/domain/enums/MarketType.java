package com.bookmaker.odds.service.domain.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum MarketType {
    TWO_WAY(List.of("ou")),
    THREE_WAY(List.of("1x2"));

    private final List<String> marketCodeList;
    private static final Map<String, MarketType> marketTypeMap = new HashMap<>();
    MarketType(List<String> marketCodeList) {
        this.marketCodeList = marketCodeList;
    }

    public static MarketType getByMarketCode(String code) {
        return marketTypeMap.get(code);
    }

    static {
        for (MarketType marketType : MarketType.values()) {
            for (String marketCode : marketType.marketCodeList) {
                marketTypeMap.put(marketCode, marketType);
            }
        }
    }
}
