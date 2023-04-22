package ru.tinkoff.contest.service.enums;

import lombok.Getter;

@Getter
public enum Currency {
    RUB("RUB"),
    USD("USD"),
    GBP("GBP"),
    EUR("EUR");

    private final String currency;

    Currency(String currency) {
        this.currency = currency;
    }
}
