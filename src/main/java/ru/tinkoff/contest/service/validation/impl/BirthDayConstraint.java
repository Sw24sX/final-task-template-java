package ru.tinkoff.contest.service.validation.impl;

import ru.tinkoff.contest.service.validation.BirthDay;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BirthDayConstraint implements ConstraintValidator<BirthDay, LocalDate> {
    @Override
    public boolean isValid(LocalDate s, ConstraintValidatorContext constraintValidatorContext) {
        if (LocalDate.now().isBefore(s)) {
            return false;
        }
        var diff = ChronoUnit.YEARS.between(s, LocalDate.now());
        return diff >= 14 && diff <= 120;
    }
}
