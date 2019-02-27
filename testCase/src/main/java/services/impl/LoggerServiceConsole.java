package services.impl;

import services.LoggerService;
import types.LogMessageType;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class LoggerServiceConsole extends LoggerBase implements LoggerService {
    public void log(String message, LogMessageType type) {
        ConsoleHandler consoleHandler = new ConsoleHandler();

        logger.addHandler(consoleHandler);
        logger.log(Level.INFO, message);
    }
}