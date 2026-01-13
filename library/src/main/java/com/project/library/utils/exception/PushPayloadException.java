package com.project.library.utils.exception;

import lombok.Getter;

@Getter
public class PushPayloadException {

    private final String message;
    private final RuntimeException cause;

    public PushPayloadException(String message, RuntimeException cause) {
        this.message = message;
        this.cause = cause;
    }

    public RuntimeException toRuntimeException() {
        return new RuntimeException(message, cause);
    }

}
