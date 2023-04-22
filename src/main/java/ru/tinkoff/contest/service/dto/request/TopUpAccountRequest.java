package ru.tinkoff.contest.service.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TopUpAccountRequest {

    private Double amount;

    //Дата пополнения. Формат: YYYY-MM-DDThh:mm:ssZ
    private LocalDateTime topUpDate;
}
