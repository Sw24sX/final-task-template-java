package ru.tinkoff.contest.service.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAccountResponse {

    private Double amount;

    private String currency;
}