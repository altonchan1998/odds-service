package com.bookmaker.odds.service.domain.entity;


import com.bookmaker.odds.service.domain.enums.MatchStatus;
import com.bookmaker.odds.service.domain.valueobject.id.MatchId;
import lombok.Getter;

@Getter
public class Match extends AggregateRoot<MatchId> {
    private final MatchStatus matchStatus;


    public Match(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }
}
