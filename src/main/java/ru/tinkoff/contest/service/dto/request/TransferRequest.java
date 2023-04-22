package ru.tinkoff.contest.service.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransferRequest {

    private Integer receiverAccount;

    private Integer senderAccount;

    private Double amountInSenderCurrency;

//    Дата и время перевода. Формат: YYYY-MM-DDThh:mm:ssZ
    private LocalDateTime transferDate;
}
