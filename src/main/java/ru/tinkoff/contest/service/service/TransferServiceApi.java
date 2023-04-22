package ru.tinkoff.contest.service.service;

import ru.tinkoff.contest.service.dto.request.TransferRequest;

public interface TransferServiceApi {

    void transfer(TransferRequest transferRequest);
}
