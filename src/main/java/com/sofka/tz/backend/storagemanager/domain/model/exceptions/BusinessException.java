package com.sofka.tz.backend.storagemanager.domain.model.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
