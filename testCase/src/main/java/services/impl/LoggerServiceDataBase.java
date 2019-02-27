package services.impl;

import services.LoggerService;
import types.LogMessageType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class LoggerServiceDataBase extends LoggerBase implements LoggerService {
    public LoggerServiceDataBase() {

    }

    public void log(String message, LogMessageType type) throws Exception {
        Statement statement = getConnection().createStatement();
        statement.executeUpdate(String.format("insert into Log_Values('%s', %d)", message, type.getValue()));
    }

    private Connection getConnection() throws Exception {
        Properties connectionProps = new Properties();
        connectionProps.put("user", getParams().getProperty("database.username"));
        connectionProps.put("password", getParams().getProperty("database.password"));

        return DriverManager.getConnection(
                String.format("jdbc:%s://%s:%s/%s",
                        getParams().getProperty("database.dbms"),
                        getParams().getProperty("database.serverName"),
                        getParams().getProperty("database.portNumber"),
                        getParams().getProperty("database.name")
                ), connectionProps);
    }
}