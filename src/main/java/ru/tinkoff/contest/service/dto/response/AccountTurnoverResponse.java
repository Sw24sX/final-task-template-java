package ru.tinkoff.contest.service.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountTurnoverResponse {

    private Double amount;

    private String currency;
}
