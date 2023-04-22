package ru.tinkoff.contest.service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.contest.domain.entity.Transaction;
import ru.tinkoff.contest.domain.repository.AccountRepository;
import ru.tinkoff.contest.domain.repository.TransactionRepository;
import ru.tinkoff.contest.service.dto.request.TransferRequest;
import ru.tinkoff.contest.service.enums.Currency;
import ru.tinkoff.contest.service.exception.EntityNotFound;
import ru.tinkoff.contest.service.exception.ServiceException;
import ru.tinkoff.contest.service.service.TransferServiceApi;

@Service
@RequiredArgsConstructor
public class TransferService implements TransferServiceApi {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    @Transactional
    public void transfer(TransferRequest transferRequest) {
        var sourceAccount = accountRepository.findByIdPessimisticLock(transferRequest.getSenderAccount())
                .orElseThrow(() -> new EntityNotFound("Account sender by number %s not found", transferRequest.getSenderAccount()));

        var targetAccount = accountRepository.findByIdPessimisticLock(transferRequest.getReceiverAccount())
                .orElseThrow(() -> new EntityNotFound("Account receiver by number %s not found", transferRequest.getReceiverAccount()));

        var amount = convertMoney(sourceAccount.getCurrency(), targetAccount.getCurrency(), transferRequest.getAmountInSenderCurrency());

        if (sourceAccount.getAmount() - amount < 0) {
            throw new ServiceException("money is not enough");
        }

        sourceAccount.setAmount(sourceAccount.getAmount() - transferRequest.getAmountInSenderCurrency());
        accountRepository.save(sourceAccount);

        targetAccount.setAmount(targetAccount.getAmount() + amount);
        accountRepository.save(targetAccount);

        var transactionTarget = new Transaction();
        transactionTarget.setTarget(targetAccount);
        transactionTarget.setDateTime(transferRequest.getTransferDate());
        transactionTarget.setAmount(amount);
        transactionRepository.save(transactionTarget);

        var transactionSource = new Transaction();
        transactionSource.setTarget(sourceAccount);
        transactionSource.setAmount(transferRequest.getAmountInSenderCurrency() * (-1));
        transactionSource.setDateTime(transferRequest.getTransferDate());
        transactionRepository.save(transactionSource);
    }

    private Double convertMoney(Currency source, Currency target, Double amount) {

        // TODO: 22.04.2023
        return amount;
    }
}
