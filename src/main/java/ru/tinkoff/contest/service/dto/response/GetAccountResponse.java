package ru.tinkoff.contest.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.tinkoff.contest.service.enums.Currency;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAccountResponse {

    private Double amount;

    private Currency currency;
}
