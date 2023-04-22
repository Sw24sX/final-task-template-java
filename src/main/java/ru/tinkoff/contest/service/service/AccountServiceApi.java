package ru.tinkoff.contest.service.service;

import ru.tinkoff.contest.service.dto.request.AccountCreateRequest;
import ru.tinkoff.contest.service.dto.request.TopUpAccountRequest;
import ru.tinkoff.contest.service.dto.response.AccountCreateResponse;
import ru.tinkoff.contest.service.dto.response.GetAccountResponse;

public interface AccountServiceApi {

    AccountCreateResponse create(AccountCreateRequest request);

    GetAccountResponse getByNumber(Integer number);

    void topUpAccount(Integer accountNumber, TopUpAccountRequest topUpAccountRequest);
}
