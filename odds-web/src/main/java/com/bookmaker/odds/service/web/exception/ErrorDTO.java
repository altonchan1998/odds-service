package com.bookmaker.odds.service.web.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
public record ErrorDTO(String code, String message) {
}