package com.bookmaker.odds.service.domain.entity;


import com.bookmaker.odds.service.domain.enums.MatchStatus;
import com.bookmaker.odds.service.domain.valueobject.Country;
import com.bookmaker.odds.service.domain.valueobject.id.AwayId;
import com.bookmaker.odds.service.domain.valueobject.id.HomeId;
import com.bookmaker.odds.service.domain.valueobject.id.InnoMatchId;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InnoMatch extends AggregateRoot<InnoMatchId> {
    private MatchStatus matchStatus;
    private final HomeId homeId;
    private final AwayId awayId;
    private final Country Country;

    public InnoMatch(InnoMatchId innoMatchId, MatchStatus matchStatus, HomeId homeId, AwayId awayId, Country Country) {
        super.setId(innoMatchId);
        this.homeId = homeId;
        this.awayId = awayId;
        this.Country = Country;
        this.matchStatus = matchStatus;
    }
}
