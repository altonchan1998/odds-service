package com.bookmaker.odds.service.application.service.port.output;

import com.bookmaker.odds.service.domain.entity.InnoMatch;
import com.bookmaker.odds.service.domain.enums.MatchStatus;
import com.bookmaker.odds.service.domain.valueobject.id.InnoMatchId;

import java.util.Optional;

public interface InnoMatchRepository {
    Optional<InnoMatch> findByMatchInnoId(InnoMatchId innoMatchId, MatchStatus matchStatus);
}
