package services;

import types.LogMessageType;

public interface LoggerService {
    public void log(String message, LogMessageType type) throws Exception;
}
