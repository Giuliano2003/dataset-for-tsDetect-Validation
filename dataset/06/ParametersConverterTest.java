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

    /* Checks that the appending ParametersConverter instance correctly converts from Map sources. */
    @Test
    public void testAppendingParametersConverterMapSource() {
        String value = new String("testAppendingParametersConverterMapSource");
        String key = new String("key2");
        HashMap<String, String> source = new HashMap<>();
        source.put(key, value);
        Parameters target = new Parameters();
        target.addParameter("key1", "value1");
        Parameters result = (Parameters) ParametersConverter.getInstance(true).convert(target, source);
        assertNotNull(result);
        assertEquals(value, result.getParameter(key));
        assertEquals("value1", result.getParameter("key1"));
    }
}