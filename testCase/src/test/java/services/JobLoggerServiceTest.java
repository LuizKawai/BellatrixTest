package services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.impl.JobLoggerServiceImpl;
import types.LogMessageType;
import types.LogStoreType;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;

public class JobLoggerServiceTest {
    private JobLoggerService jobLoggerService;

    @InjectMocks
    private JobLoggerServiceImpl jobLoggerMockService;

    @Mock
    private LoggerService loggerService;

    private static String TEST_MESSAGE = "TEST CASE";

    @Before
    public void setUp() throws Exception {
        jobLoggerService = new JobLoggerServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogInfoByConsole() throws Exception {
        jobLoggerService.log(LogMessageType.MESSAGE, LogStoreType.CONSOLE, TEST_MESSAGE);
    }

    @Test
    public void testLogInfoByFile() throws Exception {
        jobLoggerService.log(LogMessageType.MESSAGE, LogStoreType.FILE, TEST_MESSAGE);
    }

    @Test
    public void testLogInfoByDatabase() throws Exception {
        //doThrow(new RuntimeException()).when(loggerService).log(TEST_MESSAGE,LogMessageType.MESSAGE);
        doNothing().when(loggerService).log(TEST_MESSAGE,LogMessageType.MESSAGE);
        //jobLoggerMockService.log(LogMessageType.MESSAGE, LogStoreType.DATABASE, TEST_MESSAGE);
    }

    @Test
    public void testLogErrorByConsole() throws Exception {
        jobLoggerService.log(LogMessageType.ERROR, LogStoreType.CONSOLE, TEST_MESSAGE);
    }

    @Test
    public void testLogErrorByFile() throws Exception {
        jobLoggerService.log(LogMessageType.ERROR, LogStoreType.FILE, TEST_MESSAGE);
    }

    @Test
    public void testLogErrorByDatabase() throws Exception {
        doNothing().when(loggerService).log(TEST_MESSAGE,LogMessageType.ERROR);
        //jobLoggerService.log(LogMessageType.ERROR, LogStoreType.DATABASE, TEST_MESSAGE);
    }

    @Test
    public void testLogWarningByConsole() throws Exception {
        jobLoggerService.log(LogMessageType.WARNING, LogStoreType.CONSOLE, TEST_MESSAGE);
    }

    @Test
    public void testLogWarningByFile() throws Exception {
        jobLoggerService.log(LogMessageType.WARNING, LogStoreType.FILE, TEST_MESSAGE);
    }

    @Test
    public void testLogWarningByDatabase() throws Exception {
        doNothing().when(loggerService).log(TEST_MESSAGE,LogMessageType.WARNING);
        //jobLoggerService.log(LogMessageType.WARNING, LogStoreType.DATABASE, TEST_MESSAGE);
    }

    @Test
    public void testMultiLogWarningError() throws Exception{
        List<LogMessageType> messageType = new ArrayList<>();
        messageType.add(LogMessageType.WARNING);
        messageType.add(LogMessageType.ERROR);

        List<LogStoreType> storeTypes = new ArrayList<>();
        storeTypes.add(LogStoreType.CONSOLE);
        storeTypes.add(LogStoreType.FILE);

        jobLoggerService.multiLog(messageType, storeTypes, LogMessageType.MESSAGE, TEST_MESSAGE);
    }
}
