package com.project.library.utils.exception;

public record PushPayloadException(String message, RuntimeException cause) {

    public RuntimeException toRuntimeException() {
        return new RuntimeException(message, cause);
    }

}
