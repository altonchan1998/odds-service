package com.bookmaker.odds.service.application.service.port.input.service;

import com.bookmaker.odds.service.application.service.dto.AdjustMarketOddsCommand;
import com.bookmaker.odds.service.application.service.dto.AdjustMarketOddsResponse;

public interface OddsApplicationService {
    void initializeTwoWayMarketOddsCalculator();
    AdjustMarketOddsResponse adjustOdds(AdjustMarketOddsCommand command);
}
