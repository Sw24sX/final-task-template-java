package ru.tinkoff.contest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.contest.service.dto.request.TransferRequest;
import ru.tinkoff.contest.service.service.TransferServiceApi;

@RestController
@RequestMapping("/api/v1/transfers")
@RequiredArgsConstructor
public class TransfersController {

    private final TransferServiceApi transferServiceApi;

    @PostMapping
    public void transfer(@RequestBody TransferRequest transferRequest) {

//        Проверить данные в запросе:
//
//        Проверить наличие обязательных параметров в запросе и формат значений.
//                Проверить, что amountInSenderCurrency в запросе > 0. Если нет, вернуть ошибку.
//
//
//                Найти в таблице account записи по senderAccount и receiverAccount. Если выборка пустая, вернуть ошибку.
//                Проверить, что баланс отправителя >= amountInSenderCurrency. Если нет, вернуть ошибку.
//                Проверить валюту счета отправителя и счета получателя.
//
//        Если валюты равны, то нужно обновить балансы на amountInSenderCurrency.
//                Если валюты НЕ равны, то надо конвертировать
//        курс валюты отправителя к валюте получателя по топику Кафки. Использовать надо текущий актуальный курс,
//                вне зависимости от времени перевода.
//        Обновить балансы:
//
//
//        Вычесть отправленную сумму со счета отправителя.
//        Добавить к балансу счета получателя сумму транзакции с учетом текущего курса.
//
//
//                Сохранить информацию о переводе в базе данных.
//        В случае успеха вернуть ответ HTTP 200 OK.
//
//
//                В случае невалидного запроса вернуть HTTP 400.
//        Если какого-либо счета не существует, то вернуть HTTP 400.
//        В случае ошибок во время работы метода, вернуть HTTP 500.

        transferServiceApi.transfer(transferRequest);
    }
}
