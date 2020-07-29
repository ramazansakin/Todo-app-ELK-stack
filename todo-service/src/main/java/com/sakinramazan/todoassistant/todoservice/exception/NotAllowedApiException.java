package com.sakinramazan.todoassistant.todoservice.exception;

public class NotAllowedApiException extends RuntimeException {
    public NotAllowedApiException(String message) {
        super("Requested URL is not allowed now : [" + message + "]");
    }
}
