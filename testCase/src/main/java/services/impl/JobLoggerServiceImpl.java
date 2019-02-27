package services.impl;

import factories.LogMessageServiceFactory;
import factories.LoggerServiceFactory;
import services.JobLoggerService;
import services.LogMessageService;
import services.LoggerService;
import types.LogMessageType;
import types.LogStoreType;

import java.util.List;

public class JobLoggerServiceImpl implements JobLoggerService {

    @Override
    public void log(LogMessageType messageType, LogStoreType storeType, String message) throws Exception {
        if (message != null && !message.trim().isEmpty()) {
            LogMessageService logMessageService = LogMessageServiceFactory.getLogMessage(messageType.getValue());
            LoggerService loggerService = LoggerServiceFactory.getLogger(storeType);

            String finalMessage = logMessageService.getMessage(message);
            loggerService.log(finalMessage, messageType);
        }
    }

    @Override
    public void multiLog(List<LogMessageType> typesAllow, List<LogStoreType> storeTypes, final LogMessageType messageType, final String message) throws Exception {
        if (typesAllow != null && typesAllow.contains(messageType)){
            storeTypes.forEach(storeType -> {
                try {
                    log(messageType, storeType, message);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}