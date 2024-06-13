package com.bookmaker.odds.service.application.service.handler;

import com.bookmaker.odds.service.application.service.dto.AdjustMarketOddsCommand;
import com.bookmaker.odds.service.application.service.dto.AdjustMarketOddsResponse;
import com.bookmaker.odds.service.application.service.mapper.OddsDataMapper;
import com.bookmaker.odds.service.application.service.port.output.JuiceRepository;
import com.bookmaker.odds.service.domain.entity.Market;
import com.bookmaker.odds.service.domain.entity.OddsAdjustableMarket;
import com.bookmaker.odds.service.domain.valueobject.Juice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdjustMarketOddsCommandHandler implements CommandHandler<AdjustMarketOddsCommand, AdjustMarketOddsResponse> {
    private final OddsDataMapper oddsDataMapper;
    private final JuiceRepository juiceRepository;

    public AdjustMarketOddsResponse handle(AdjustMarketOddsCommand command) {
        Market market = oddsDataMapper.toMarket(command);
        Juice desiredMatchJuice = juiceRepository.findDesiredMatchJuiceByMatch(market.getMatch());
        Juice desiredTournamentJuice = juiceRepository.findDesiredTournamentJuiceByMatch((market.getMatch()));

        OddsAdjustableMarket oddsAdjustableMarket = oddsDataMapper.toOddsAdjustableMarket(market, command.getVendor(), desiredMatchJuice, desiredTournamentJuice);
        oddsAdjustableMarket.adjustOdds();

        return oddsDataMapper.toAdjustMarketOddsResponse(oddsAdjustableMarket);
    }
}
