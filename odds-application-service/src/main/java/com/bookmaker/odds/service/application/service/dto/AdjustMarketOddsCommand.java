package com.bookmaker.odds.service.application.service.dto;

import com.bookmaker.odds.service.domain.entity.BettingOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AdjustMarketOddsCommand implements Command {
    private Long sid;
    private Long id;
    private Long mid;
    private String vendor;
    private boolean isInPlay;
    private String marketCode;
    private List<BettingOption> bettingOptions;
}
