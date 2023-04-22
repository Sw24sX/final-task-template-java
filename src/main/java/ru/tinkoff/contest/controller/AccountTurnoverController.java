package ru.tinkoff.contest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.contest.service.dto.request.AccountTurnoverRequest;
import ru.tinkoff.contest.service.dto.response.AccountTurnoverResponse;

@RestController
@RequestMapping("/api/v1/account-turnover")
@RequiredArgsConstructor
public class AccountTurnoverController {

    @GetMapping("/{accountNumber}")
    public AccountTurnoverResponse accountTurnover(@PathVariable Integer accountNumber,
                                                   @RequestBody AccountTurnoverRequest accountTurnoverRequest) {

//        Проверить в запросе:
//
//        Наличие обязательных параметров и формат переданных в них значений.
//                Если переданы параметры startDate и endDate, то проверить что startDate < endDate. Если нет, вернуть ошибку.
//
//
//                Найти в базе данных счет по переданному accountNumber.
//
//                Если счет не найден, то вернуть ошибку.
//        Если найден, то продолжить.
//
//
//                Сделать выборку переводов и пополнений по accountNumber из запроса и переданному временному интервалу
//        (при наличии). Посчитать сумму по дебету и кредиту.
//        В случае успеха вернуть ответ HTTP 200 OK.
//
//
//                В случае невалидного запроса, вернуть HTTP 400.
//        Если счета не существует, то вернуть HTTP 400.
//        В случае ошибок во время работы метода, вернуть HTTP 500.

        return null;
    }
}
