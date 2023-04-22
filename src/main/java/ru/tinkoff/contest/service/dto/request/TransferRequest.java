package ru.tinkoff.contest.service.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransferRequest {

    @NotNull
    private Integer receiverAccount;

    @NotNull
    private Integer senderAccount;

    @NotNull
    @Min(0)
    private Double amountInSenderCurrency;

    @NotNull
    private LocalDateTime transferDate;
}
