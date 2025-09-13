package io.rivulet.test;

import io.rivulet.converter.*;
import org.apache.tomcat.util.buf.ByteChunk;
import org.apache.tomcat.util.http.Parameters;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

/* Test the behavior of ForcedTypeConverter implementations. */
public class ConversionTest {

    /* Checks that the appending CookieMapConverter instance correctly converts from Map sources. */
    @Test
    public void testAppendingCookieMapConverter() {
        HashMap<String, String> source = new HashMap<>();
        source.put("name2", "newValue2");
        source.put("name4", "newValue4");
        String target = "name1=value1; name2=value2; name3=value3";
        String result =  (String) CookieMapConverter.getInstance(true).convert(target, source);
        assertNotNull(result);
        HashMap<String, String> actual = CookieMapConverter.parseOriginalCookie(result);
        HashMap<String, String> expected = new HashMap<>(source);
        expected.put("name1", "value1");
        expected.put("name3", "value3");
        assertEquals(expected, actual);
    }
}