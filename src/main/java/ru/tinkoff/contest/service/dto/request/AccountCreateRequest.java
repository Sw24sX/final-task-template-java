package ru.tinkoff.contest.service.dto.request;

import lombok.Getter;
import lombok.Setter;
import ru.tinkoff.contest.service.enums.Currency;
import ru.tinkoff.contest.service.validation.BirthDay;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class AccountCreateRequest {

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    private String country;

    @NotNull
    @BirthDay
    private LocalDate birthDay;

    @NotNull
    private Currency currency;
}
