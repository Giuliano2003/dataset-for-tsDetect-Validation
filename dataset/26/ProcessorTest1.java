

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
    *Test loginAdmin method for an incorrect password
    */
    @Test
    public void testFailLoginAdmin() {
      boolean result = processor.loginAdmin("admi");
      assertFalse(result);
    }


    /**
    *Test logoutAdmin method by logging in first
    */
    @Test
    public void testLoginAndLogout() {
        processor.loginAdmin("admin");
        assertTrue(processor.getCurrentUser());
        processor.logoutAdmin();
        assertTrue(processor.getCurrentUser());
    }

    @Test
    public void testHistoryStatistic() {

        // set the date of start and end
        LocalDate start = LocalDate.of(2020, 9, 25);
        LocalDate end = LocalDate.of(2020, 9, 26);

        //create a List<ExchangeRecordPair>
        List<ExchangeRecordPair> hist = processor.getHistory("CAD", "JPY", start, end);
        assertEquals(hist.size(), 2);

        //the actual Map of history statistic
        Map<String, Double> histStat = processor.historyStatistic(processor.getHistory("CAD", "JPY",
                start, end));

        //put the expected value into the expected Map
        Map<String, Double> expected = new HashMap<>();
        expected.put("Average 1", 78.8063215);
        expected.put("Average 2", 0.0126895);
        expected.put("Median 1", 78.8063215);
        expected.put("Median 2", 0.0126895);
        expected.put("Maximum 1", 78.871945);
        expected.put("Maximum 2", 0.0127);
        expected.put("Minimum 1", 78.740698);
        expected.put("Minimum 2", 0.012679);
        expected.put("Standard Deviation 1", 0.06562350000000094);
        expected.put("Standard Deviation 2", 1.0500000000000093E-5);

        //in this point we need to make sure the assertEquals has same object to compare
        //in the situation below we have same Map<String,Double> type to compare
        assertEquals(expected.get("Average 1"), histStat.get("Average 1"));
        assertEquals(expected.get("Average 2"), histStat.get("Average 2"));
        assertEquals(expected.get("Median 1"), histStat.get("Median 1"));
        assertEquals(expected.get("Median 2"), histStat.get("Median 2"));
        assertEquals(expected.get("Maximum 1"), histStat.get("Maximum 1"));
        assertEquals(expected.get("Maximum 2"), histStat.get("Maximum 2"));
        assertEquals(expected.get("Minimum 1"), histStat.get("Minimum 1"));
        assertEquals(expected.get("Minimum 2"), histStat.get("Minimum 2"));
        assertEquals(expected.get("Standard Deviation 1"), histStat.get("Standard Deviation 1"));
        assertEquals(expected.get("Standard Deviation 2"), histStat.get("Standard Deviation 2"));
    }

    /**
    * Test the convert method
    */
    @Test
    public void testConvert() {
        double result = processor.convert("AUD", "CAD", 100.0);
        assertEquals(95.4143, result, 0.00000000);
    }

}