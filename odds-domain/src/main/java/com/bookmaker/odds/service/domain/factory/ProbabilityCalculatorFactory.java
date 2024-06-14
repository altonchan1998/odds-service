package com.bookmaker.odds.service.domain.factory;


import com.bookmaker.odds.service.domain.calculator.probability.ProbabilityCalculator;
import com.bookmaker.odds.service.domain.calculator.probability.ThreeWayMarketProbabilityCalculator;
import com.bookmaker.odds.service.domain.calculator.probability.TwoWayMarketProbabilityCalculator;
import com.bookmaker.odds.service.domain.enums.MarketType;

import java.util.EnumMap;

public class ProbabilityCalculatorFactory {
    private ProbabilityCalculatorFactory() {}

    private static final EnumMap<MarketType, ProbabilityCalculator> map = new EnumMap<>(MarketType.class);

    public static ProbabilityCalculator getBettingOddsModifier(MarketType marketType) {
        return switch (marketType) {
            case TWO_WAY -> TwoWayMarketProbabilityCalculator.getInstance();
            case THREE_WAY, INFINITE_WAY -> ThreeWayMarketProbabilityCalculator.getInstance();
        };
    }
}
