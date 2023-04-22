package ru.tinkoff.contest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.contest.service.dto.response.AccountTurnoverResponse;
import ru.tinkoff.contest.service.exception.NotValidException;
import ru.tinkoff.contest.service.service.AccountTurnoverServiceApi;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/account-turnover")
@RequiredArgsConstructor
@Validated
public class AccountTurnoverController {

    private final AccountTurnoverServiceApi accountTurnoverServiceApi;

    @GetMapping("/{accountNumber}")
    public AccountTurnoverResponse accountTurnover(@PathVariable Integer accountNumber,
                                                   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

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


        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            throw new NotValidException("Start date before end date");
        }

        return accountTurnoverServiceApi.accountTurnover(accountNumber, startDate, endDate);
    }
}
