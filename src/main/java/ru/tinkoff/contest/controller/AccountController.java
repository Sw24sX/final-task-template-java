package ru.tinkoff.contest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.contest.service.service.AccountServiceApi;
import ru.tinkoff.contest.service.dto.request.AccountCreateRequest;
import ru.tinkoff.contest.service.dto.request.TopUpAccountRequest;
import ru.tinkoff.contest.service.dto.response.AccountCreateResponse;
import ru.tinkoff.contest.service.dto.response.GetAccountResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
@Validated
public class AccountController {

    private final AccountServiceApi accountServiceApi;

    @PostMapping
    public AccountCreateResponse createAccount(@Valid @RequestBody AccountCreateRequest accountCreateRequest) {

        return accountServiceApi.create(accountCreateRequest);
    }

    @GetMapping("/{accountNumber}")
    public GetAccountResponse getAccount(@PathVariable Integer accountNumber) {

//        Проверить наличие обязательных параметров в запросе.
//        Найти в базе данных счет по переданному accountNumber.
//
//        Если счет не найден, то вернуть ошибку.
//        Если найден - вернуть в ответе в параметрах amount и currency значения из базы данных.
//
//
//                В случае успеха вернуть ответ HTTP 200 OK.
//
//
//                В случае невалидного запроса вернуть HTTP 400.
//        Если счета не существует, то вернуть HTTP 400.
//        В случае ошибок во время работы метода, вернуть HTTP 500.

        return accountServiceApi.getByNumber(accountNumber);
    }

    @PostMapping("/{accountNumber}/top-up")
    public void topUpAccount(@PathVariable Integer accountNumber, @Valid @RequestBody TopUpAccountRequest topUpAccountRequest) {

//        Проверить наличие обязательных параметров в запросе и формат значений.
//                Найти в таблице account запись с accountNumber из запроса. Если не найдена - вернуть ошибку.
//                Проверить, что amount в запросе > 0. Если нет, вернуть ошибку.
//                Сохранить информацию о пополнении в базу данных.
//        Обновить поле account.amount = account.amount + amount из запроса и вернуть в ответе 200 OK.
//
//
//                В случае невалидного запроса, вернуть HTTP 400.
//        Если счета не существует, то вернуть HTTP 400.
//        В случае ошибок во время работы метода, вернуть HTTP 500.

        accountServiceApi.topUpAccount(accountNumber, topUpAccountRequest);
    }
}
