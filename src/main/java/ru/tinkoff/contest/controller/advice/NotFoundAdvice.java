package ru.tinkoff.contest.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.tinkoff.contest.service.exception.EntityNotFound;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class NotFoundAdvice {

    @ExceptionHandler({EntityNotFound.class, MethodArgumentNotValidException.class})
    public ResponseEntity handle() {
        return status(HttpStatus.BAD_REQUEST).build();
    }
}
