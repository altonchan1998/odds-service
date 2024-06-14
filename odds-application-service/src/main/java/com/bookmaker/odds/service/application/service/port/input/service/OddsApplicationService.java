package com.bookmaker.odds.service.application.service.port.input.service;

import com.bookmaker.odds.service.application.service.dto.command.AdjustMarketOddsCommand;
import com.bookmaker.odds.service.application.service.dto.response.AdjustMarketOddsResponse;

public interface OddsApplicationService {
    void initializeTwoWayMarketOddsCalculator();
    AdjustMarketOddsResponse adjustOdds(AdjustMarketOddsCommand command);
}
