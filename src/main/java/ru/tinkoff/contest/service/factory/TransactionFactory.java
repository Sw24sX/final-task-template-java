package ru.tinkoff.contest.service.factory;

import ru.tinkoff.contest.domain.entity.Transaction;
import ru.tinkoff.contest.service.dto.request.TopUpAccountRequest;

public class TransactionFactory {

    public static Transaction to(TopUpAccountRequest topUpAccountRequest) {
        var result = new Transaction();
        result.setDateTime(topUpAccountRequest.getTopUpDate());
        result.setAmount(topUpAccountRequest.getAmount());
        return result;
    }
}
