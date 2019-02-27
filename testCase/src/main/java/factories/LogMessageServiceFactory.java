package factories;

import services.LogMessageService;
import services.impl.LogMessageServiceError;
import services.impl.LogMessageServiceInfo;
import services.impl.LogMessageServiceWarning;
import types.LogMessageType;

public class LogMessageServiceFactory {
    private LogMessageServiceFactory() {
    }

    public static LogMessageService getLogMessage(int type) {
        if (type == LogMessageType.MESSAGE.getValue()) {
            return new LogMessageServiceInfo();
        } else if (type == LogMessageType.ERROR.getValue()) {
            return new LogMessageServiceError();
        } else if (type == LogMessageType.WARNING.getValue()) {
            return new LogMessageServiceWarning();
        } else {
            return null;
        }
    }
}
