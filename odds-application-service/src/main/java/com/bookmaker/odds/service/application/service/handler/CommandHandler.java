package com.bookmaker.odds.service.application.service.handler;

import com.bookmaker.odds.service.application.service.dto.Command;

public interface CommandHandler<T extends Command, R> {
    R handle(T command);
}
