package ru.tinkoff.contest.service.validation.impl;

import ru.tinkoff.contest.service.validation.MinDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class MinDateConstraint implements ConstraintValidator<MinDate, LocalDateTime> {
    @Override
    public boolean isValid(LocalDateTime localDate, ConstraintValidatorContext constraintValidatorContext) {
        return LocalDateTime.now().isAfter(localDate);
    }
}
