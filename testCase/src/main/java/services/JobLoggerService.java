package services;

import types.LogMessageType;
import types.LogStoreType;

import java.util.List;

public interface JobLoggerService {
    public void log(LogMessageType messageType, LogStoreType storeType, String message) throws Exception;

    public void multiLog(List<LogMessageType> typesAllow, List<LogStoreType> storeTypes, LogMessageType messageType, String message) throws Exception;
}
