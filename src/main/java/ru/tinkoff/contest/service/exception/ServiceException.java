package ru.tinkoff.contest.service.exception;

public class ServiceException extends RuntimeException {

    public ServiceException(String message, Object... args) {
        super(String.format(message, args));
    }
}
