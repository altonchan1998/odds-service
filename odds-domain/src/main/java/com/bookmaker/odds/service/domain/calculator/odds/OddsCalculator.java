package com.bookmaker.odds.service.domain.calculator.odds;

import com.bookmaker.odds.service.domain.valueobject.Juice;
import com.bookmaker.odds.service.domain.valueobject.Odds;

import java.util.List;

public interface OddsCalculator {
    List<Odds> calculate(List<Odds> oddsList, Juice desiredJuice);
}
