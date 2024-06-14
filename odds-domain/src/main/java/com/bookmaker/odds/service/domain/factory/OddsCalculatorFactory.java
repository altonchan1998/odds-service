package com.bookmaker.odds.service.domain.factory;


import com.bookmaker.odds.service.domain.calculator.odds.OddsCalculator;
import com.bookmaker.odds.service.domain.calculator.odds.ThreeWayMarketOddsCalculator;
import com.bookmaker.odds.service.domain.calculator.odds.TwoWayMarketOddsCalculator;
import com.bookmaker.odds.service.domain.enums.MarketType;

import java.util.EnumMap;

public class OddsCalculatorFactory {
    private OddsCalculatorFactory() {}

    private static final EnumMap<MarketType, OddsCalculator> map = new EnumMap<>(MarketType.class);

    public static OddsCalculator getCalculator(MarketType marketType) {
        return switch (marketType) {
            case TWO_WAY -> TwoWayMarketOddsCalculator.getInstance();
            case THREE_WAY, INFINITE_WAY -> ThreeWayMarketOddsCalculator.getInstance();
        };
    }
}
