package com.bookmaker.odds.service.domain.enums;

public enum OddsVendor {
    BTI("f");

    OddsVendor(String code) {
        this.code = code;
    }

    private final String code;

    public static OddsVendor getByCode(String code) {
        return OddsVendor.valueOf(code);
    }


}
