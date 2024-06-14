package com.bookmaker.odds.service.application.service.dto.command;

import com.bookmaker.odds.service.application.service.dto.Command;
import com.bookmaker.odds.service.domain.valueobject.BettingOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AdjustMarketOddsCommand implements Command {
    private final Long sid;
    private final Long iid;
    private final Long mid;
    private final String vendorCode;
    private final Boolean inPlay;
    private final String marketCode;
    private final List<BettingOption> bettingOptions;
}
