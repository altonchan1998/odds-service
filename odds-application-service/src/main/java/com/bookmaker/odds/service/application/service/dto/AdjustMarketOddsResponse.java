package com.bookmaker.odds.service.application.service.dto;

import com.bookmaker.odds.service.domain.entity.BettingOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AdjustMarketOddsResponse {
    private List<BettingOption> bettingOptions;
}
