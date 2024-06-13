package com.bookmaker.odds.service.application.service.port.output;

import com.bookmaker.odds.service.domain.entity.Market;
import com.bookmaker.odds.service.domain.entity.Match;
import com.bookmaker.odds.service.domain.valueobject.Juice;

public interface JuiceRepository {
    Juice findDesiredMatchJuiceByMatch(Match match);
    Juice findDesiredTournamentJuiceByMatch(Match match);
}
