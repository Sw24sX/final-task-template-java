package ru.tinkoff.contest.service.service;

import ru.tinkoff.contest.service.dto.response.AccountTurnoverResponse;

import java.time.LocalDateTime;

public interface AccountTurnoverServiceApi {

    AccountTurnoverResponse accountTurnover(Integer accountNumber, LocalDateTime startDate, LocalDateTime endDate);
}
