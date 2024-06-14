package com.bookmaker.odds.service.domain.factory;


import com.bookmaker.odds.service.domain.calculator.odds.OddsCalculator;
import com.bookmaker.odds.service.domain.calculator.odds.ThreeWayMarketOddsCalculator;
import com.bookmaker.odds.service.domain.calculator.odds.TwoWayMarketOddsCalculator;
import com.bookmaker.odds.service.domain.enums.MarketType;

import java.util.EnumMap;
import java.util.Optional;

public class OddsCalculatorFactory {
    private OddsCalculatorFactory() {}

    private static final EnumMap<MarketType, OddsCalculator> map = new EnumMap<>(MarketType.class);

    public static OddsCalculator getCalculator(MarketType marketType) {
        return Optional.ofNullable(map.get(marketType))
                .orElseThrow();
    }

    static {
        map.put(MarketType.TWO_WAY, TwoWayMarketOddsCalculator.getInstance());
        map.put(MarketType.THREE_WAY, ThreeWayMarketOddsCalculator.getInstance());
        map.put(MarketType.INFINITE_WAY, ThreeWayMarketOddsCalculator.getInstance());
    }
}
