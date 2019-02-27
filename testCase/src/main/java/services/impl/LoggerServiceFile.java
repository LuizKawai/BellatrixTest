package services.impl;

import services.LoggerService;
import types.LogMessageType;

import java.util.logging.FileHandler;
import java.util.logging.Level;

public class LoggerServiceFile extends LoggerBase implements LoggerService {
    public void log(String message, LogMessageType type) throws Exception {
        FileHandler fileHandler = new FileHandler(String.format("%s/%s", getParams().getProperty("file.folder"), getParams().getProperty("file.name")));

        logger.addHandler(fileHandler);
        logger.log(Level.INFO, message);
    }
}
