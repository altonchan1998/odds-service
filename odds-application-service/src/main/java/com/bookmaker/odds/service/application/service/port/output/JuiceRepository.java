package com.bookmaker.odds.service.application.service.port.output;

import com.bookmaker.odds.service.domain.entity.InnoMatch;
import com.bookmaker.odds.service.domain.valueobject.Juice;

import java.util.Optional;

public interface JuiceRepository {
    Optional<Juice> findDesiredMatchJuiceByInnoMatch(InnoMatch innoMatch);
    Optional<Juice> findDesiredTournamentJuiceByInnoMatch(InnoMatch innoMatch);
}
