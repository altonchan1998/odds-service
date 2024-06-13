package com.bookmaker.odds.service.domain.calculator.probability;

import com.bookmaker.odds.service.domain.valueobject.Odds;
import com.bookmaker.odds.service.domain.valueobject.Probability;

public interface ProbabilityCalculator {
    Probability calculate(Odds odds);
}
