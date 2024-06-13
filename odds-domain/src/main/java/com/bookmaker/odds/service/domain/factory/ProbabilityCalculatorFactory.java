package com.bookmaker.odds.service.domain.factory;


import com.bookmaker.odds.service.domain.calculator.probability.ProbabilityCalculator;
import com.bookmaker.odds.service.domain.calculator.probability.ThreeWayMarketProbabilityCalculator;
import com.bookmaker.odds.service.domain.calculator.probability.TwoWayMarketProbabilityCalculator;
import com.bookmaker.odds.service.domain.enums.MarketType;

import java.util.EnumMap;
import java.util.Optional;

public class ProbabilityCalculatorFactory {
    private ProbabilityCalculatorFactory() {}

    private static EnumMap<MarketType, ProbabilityCalculator> map = new EnumMap<>(MarketType.class);

    public static ProbabilityCalculator getBettingOddsModifier(MarketType marketType) {
        return Optional.ofNullable(map.get(marketType))
                .orElseThrow();
    }

    static {
        map.put(MarketType.TWO_WAY, TwoWayMarketProbabilityCalculator.getInstance());
        map.put(MarketType.THREE_WAY, ThreeWayMarketProbabilityCalculator.getInstance());
    }
}
