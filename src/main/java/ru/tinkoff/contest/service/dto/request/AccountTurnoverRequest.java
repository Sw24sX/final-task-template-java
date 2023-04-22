package ru.tinkoff.contest.service.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountTurnoverRequest {

    private Integer accountNumber;

//    Дата начала периода, формат: yyyy-mm-ddThh:mm:ssZ
    private LocalDateTime startDate;

//    Дата окончания периода, формат: yyyy-mm-ddThh:mm:ssZ
    private LocalDateTime endDate;
}
