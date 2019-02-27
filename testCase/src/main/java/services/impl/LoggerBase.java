package services.impl;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class LoggerBase {
    protected Logger logger = Logger.getLogger(this.getClass().getCanonicalName());

    protected Properties getParams() throws Exception {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("params.properties");

        properties.load(inputStream);
        return properties;
    }
}
