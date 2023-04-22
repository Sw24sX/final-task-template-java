package ru.tinkoff.contest.service.validation.impl;

import ru.tinkoff.contest.service.validation.Currency;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CurrencyConstraint implements ConstraintValidator<Currency, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.stream(ru.tinkoff.contest.service.enums.Currency.values())
                .anyMatch(x -> x.getCurrency().equals(s));
    }
}
