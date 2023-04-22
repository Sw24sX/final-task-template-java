package ru.tinkoff.contest.service.dto.request;

import lombok.Getter;
import lombok.Setter;
import ru.tinkoff.contest.service.validation.MinDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class TopUpAccountRequest {

    @NotNull
    @Min(0)
    private Double amount;

    //Дата пополнения. Формат: YYYY-MM-DDThh:mm:ssZ
    @MinDate
    private LocalDateTime topUpDate;
}
