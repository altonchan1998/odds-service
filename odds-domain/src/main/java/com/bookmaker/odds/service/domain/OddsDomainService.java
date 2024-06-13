package com.bookmaker.odds.service.domain;

import com.bookmaker.odds.service.domain.entity.ProbabilityOddsReference;

import java.util.List;

public interface OddsDomainService {

    void initializeTwoWayMarketOddsCalculator(List<ProbabilityOddsReference> references);
}
