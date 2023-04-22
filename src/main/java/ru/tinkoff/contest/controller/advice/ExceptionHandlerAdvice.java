package ru.tinkoff.contest.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.tinkoff.contest.service.exception.EntityNotFound;
import ru.tinkoff.contest.service.exception.NotValidException;
import ru.tinkoff.contest.service.exception.ServiceException;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({EntityNotFound.class, MethodArgumentNotValidException.class, NotValidException.class, ServiceException.class})
    public ResponseEntity handle() {
        return status(HttpStatus.BAD_REQUEST).build();
    }
}
