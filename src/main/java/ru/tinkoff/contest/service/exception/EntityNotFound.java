package ru.tinkoff.contest.service.exception;

public class EntityNotFound extends ServiceException {
    public EntityNotFound(String message, Object... args) {
        super(message, args);
    }
}
