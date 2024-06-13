package com.bookmaker.odds.service.application.service.handler;

import com.bookmaker.odds.service.application.service.dto.Query;

public interface QueryHandler<T extends Query, R> {
    R handle(T command);
}
