package com.bookmaker.odds.service.application.service.dto.response;

import com.bookmaker.odds.service.domain.enums.MarketType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class MarketConfigResponse {
    private final Set<String> bettingOptionCodes;
    private final Boolean outcomeInList;
    private final MarketType marketType;
}
