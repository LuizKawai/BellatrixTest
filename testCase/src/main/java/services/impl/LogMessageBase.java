package services.impl;

import java.text.DateFormat;
import java.util.Date;

public class LogMessageBase {
    protected String now() {
        return DateFormat.getDateInstance(DateFormat.LONG).format(new Date());
    }
}
