package com.bookmaker.odds.service.application.service.handler;

import com.bookmaker.odds.service.application.service.dto.AdjustMarketOddsCommand;
import com.bookmaker.odds.service.application.service.dto.AdjustMarketOddsResponse;
import com.bookmaker.odds.service.application.service.mapper.OddsDataMapper;
import com.bookmaker.odds.service.application.service.port.output.InnoMatchRepository;
import com.bookmaker.odds.service.application.service.port.output.JuiceRepository;
import com.bookmaker.odds.service.domain.OddsDomainService;
import com.bookmaker.odds.service.domain.entity.Market;
import com.bookmaker.odds.service.domain.entity.InnoMatch;
import com.bookmaker.odds.service.domain.enums.MatchStatus;
import com.bookmaker.odds.service.domain.exception.InnoMatchNotFoundException;
import com.bookmaker.odds.service.domain.valueobject.Juice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdjustMarketOddsCommandHandler implements CommandHandler<AdjustMarketOddsCommand, AdjustMarketOddsResponse> {
    private final OddsDomainService oddsDomainService;
    private final OddsDataMapper oddsDataMapper;
    private final JuiceRepository juiceRepository;
    private final InnoMatchRepository innoMatchRepository;

    public AdjustMarketOddsResponse handle(AdjustMarketOddsCommand command) {
        Market market = oddsDataMapper.toMarket(command);

        InnoMatch innoMatch = innoMatchRepository.findByMatchInnoId(market.getInnoMatchId(), MatchStatus.fromValue(command.isInPlay()))
                .orElseThrow(() -> new InnoMatchNotFoundException("InnoMatch with iid: " + command.getIid() + " not found"));

        Juice desiredMatchJuice = juiceRepository.findDesiredMatchJuiceByInnoMatch(innoMatch)
                .orElse(null);

        Juice desiredTournamentJuice = juiceRepository.findDesiredTournamentJuiceByInnoMatch(innoMatch)
                .orElse(null);

        oddsDomainService.adjustOdds(market, desiredMatchJuice, desiredTournamentJuice);

        return oddsDataMapper.toAdjustMarketOddsResponse(market);
    }
}
