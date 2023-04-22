package ru.tinkoff.contest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.contest.domain.repository.AccountRepository;
import ru.tinkoff.contest.service.AccountServiceApi;
import ru.tinkoff.contest.service.dto.request.AccountCreateRequest;
import ru.tinkoff.contest.service.dto.request.TopUpAccountRequest;
import ru.tinkoff.contest.service.dto.response.AccountCreateResponse;
import ru.tinkoff.contest.service.dto.response.GetAccountResponse;
import ru.tinkoff.contest.service.exception.EntityNotFound;
import ru.tinkoff.contest.service.factory.AccountFactory;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountServiceApi {

    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public AccountCreateResponse create(AccountCreateRequest request) {
        var account = AccountFactory.from(request);
        var result = accountRepository.save(account);
        return AccountFactory.toCreateResponse(result);
    }

    @Override
    public GetAccountResponse getByNumber(Integer number) {
        var result = accountRepository.findById(number)
                .orElseThrow(() -> new EntityNotFound("Account by number %s not found", number));
        return AccountFactory.toGetAccountResponse(result);
    }

    @Override
    @Transactional
    public void topUpAccount(Integer accountNumber, TopUpAccountRequest topUpAccountRequest) {
        var accountLocked = accountRepository.findByIdPessimisticLock(accountNumber)
                .orElseThrow(() -> new EntityNotFound("Account by number %s not found", accountNumber));
        accountLocked.setAmount(accountLocked.getAmount() + topUpAccountRequest.getAmount());
        accountRepository.save(accountLocked);
    }
}
