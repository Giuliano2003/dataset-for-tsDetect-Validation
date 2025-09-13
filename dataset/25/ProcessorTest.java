package CurrencyConverter;

import CurrencyConverter.Model.ExchangeRecord;
import CurrencyConverter.Model.ExchangeRecordPair;
import CurrencyConverter.User.AdminUserImpl;
import CurrencyConverter.User.NormalUserImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Test Processor class
 */

/*  https://github.com/Phoebezuo/Currency-Converter/blob/master/src/test/java/CurrencyConverter/ProcessorTest.java */
public class ProcessorTest {
    Processor processor;

    /**
     * Initializing the processor for testing
     */
    @Before
    public void init() {
        try {
            processor = new Processor();
        } catch (IOException e) {
            fail("IO Exception when initializing the processor.");
        }
    }



    /**
    * test cahngePopularCurrency method for correct input
    */
    @Test
    public void testChangePopularCurrency1() throws IOException {
        processor.loginAdmin("admin");

        String[] popCur = {"USD", "HKD", "JPY", "AUD"};
        assertArrayEquals(popCur, processor.getPopularCurrencyNames());
        boolean result = processor.changePopularCurrency("JPY", "CAD");
        assertTrue(result);

        popCur[2] = "CAD";
        assertArrayEquals(popCur, processor.getPopularCurrencyNames());
    }

}