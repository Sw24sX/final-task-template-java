package ru.tinkoff.contest.service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.contest.domain.entity.Transaction;
import ru.tinkoff.contest.domain.repository.AccountRepository;
import ru.tinkoff.contest.domain.repository.TransactionRepository;
import ru.tinkoff.contest.service.dto.response.AccountTurnoverResponse;
import ru.tinkoff.contest.service.exception.EntityNotFound;
import ru.tinkoff.contest.service.service.AccountTurnoverServiceApi;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountTurnoverService implements AccountTurnoverServiceApi {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public AccountTurnoverResponse accountTurnover(Integer accountNumber, LocalDateTime startDate, LocalDateTime endDate) {

        var account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new EntityNotFound("Account with number %s not found", accountNumber));

        var result = transactionRepository.findAllByTargetAndRegionDate(account, startDate, endDate)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
        return new AccountTurnoverResponse(result, account.getCurrency());
    }
}
