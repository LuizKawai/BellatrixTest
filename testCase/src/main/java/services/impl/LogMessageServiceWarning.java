package services.impl;

import services.LogMessageService;

public class LogMessageServiceWarning extends LogMessageBase implements LogMessageService {
    private static final String PREFIX = "warning";

    public String getMessage(String message) {
        return String.format("%s %s %s", PREFIX, now(), message);
    }
}