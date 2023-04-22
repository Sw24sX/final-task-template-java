package ru.tinkoff.contest.service.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccountCreateRequest {

    private String firstName;

    private String lastName;

    private String country;

    private LocalDate birthDay;

    private String currency;
}
