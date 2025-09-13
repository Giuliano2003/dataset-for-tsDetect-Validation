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

    
    /* Checks that a ChainTypeConverter that uses the StringArrayConverter and the HeapByteBufferConverter correctly
     * applies the converters to produce its final ByteBuffer conversion result. */
    @Test
    public void testChainTypeConverter() {
        ChainedTypeConverter converter = ChainedTypeConverter.getInstance(StringArrayConverter.getByteInstance(), HeapByteBufferConverter.getInstance());
        String source = "testChainTypeConverter";
        ByteBuffer target = ByteBuffer.wrap("target".getBytes());
        ByteBuffer result = (ByteBuffer)converter.convert(target, source);
        assertNotNull(result);
        assertEquals(ByteBuffer.wrap(source.getBytes()), result);
    }
}