package services.impl;

import services.LogMessageService;

public class LogMessageServiceInfo extends LogMessageBase implements LogMessageService {
    private static final String PREFIX = "message";

    public String getMessage(String message) {
        return String.format("%s %s %s", PREFIX, now(), message);
    }
}
