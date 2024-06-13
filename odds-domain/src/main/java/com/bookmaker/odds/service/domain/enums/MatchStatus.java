package com.bookmaker.odds.service.domain.enums;

public enum MatchStatus {
    PRE_MATCH,
    IN_PLAY;

    public static MatchStatus fromValue(boolean isInPlay) {
        return isInPlay ? IN_PLAY : PRE_MATCH;
    }
}
