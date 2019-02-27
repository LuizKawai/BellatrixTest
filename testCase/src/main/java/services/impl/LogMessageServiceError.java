package services.impl;

import services.LogMessageService;

public class LogMessageServiceError extends LogMessageBase implements LogMessageService {
    private static final String PREFIX = "error";

    public String getMessage(String message) {
        return String.format("%s %s %s", PREFIX, now(), message);
    }
}