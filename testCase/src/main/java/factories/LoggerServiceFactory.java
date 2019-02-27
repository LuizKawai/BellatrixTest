package factories;

import services.LoggerService;
import services.impl.LoggerServiceConsole;
import services.impl.LoggerServiceDataBase;
import services.impl.LoggerServiceFile;
import types.LogStoreType;

public class LoggerServiceFactory {
    private LoggerServiceFactory() {
    }

    public static LoggerService getLogger(LogStoreType type) {
        if (type.equals(LogStoreType.CONSOLE)) {
            return new LoggerServiceConsole();
        } else if (type.equals(LogStoreType.FILE)) {
            return new LoggerServiceFile();
        } else if (type.equals(LogStoreType.DATABASE)) {
            return new LoggerServiceDataBase();
        } else {
            return null;
        }
    }
}
