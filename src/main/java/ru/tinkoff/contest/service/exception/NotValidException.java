package ru.tinkoff.contest.service.exception;

public class NotValidException extends RuntimeException {
    public NotValidException(String message, Object... args) {
        super(String.format(message, args));
    }
}
