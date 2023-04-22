package ru.tinkoff.contest.service.factory;

import ru.tinkoff.contest.domain.entity.Account;
import ru.tinkoff.contest.service.dto.request.AccountCreateRequest;
import ru.tinkoff.contest.service.dto.response.AccountCreateResponse;
import ru.tinkoff.contest.service.dto.response.GetAccountResponse;

public class AccountFactory {

    public static Account from(AccountCreateRequest accountCreateRequest) {
        var account = new Account();
        account.setCurrency(accountCreateRequest.getCurrency());
        account.setCountry(accountCreateRequest.getCountry());
        account.setBirthDay(accountCreateRequest.getBirthDay());
        account.setLastName(accountCreateRequest.getLastName());
        account.setFirstName(accountCreateRequest.getFirstName());
        account.setAmount(0.0);
        return account;
    }

    public static AccountCreateResponse toCreateResponse(Account account) {
        return new AccountCreateResponse(account.getId());
    }

    public static GetAccountResponse toGetAccountResponse(Account account) {
        return new GetAccountResponse(account.getAmount(), account.getCurrency());
    }
}
