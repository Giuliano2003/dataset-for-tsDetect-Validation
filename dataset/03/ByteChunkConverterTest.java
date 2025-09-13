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

    /* Checks that the ByteChunkConverter singleton instance sets the bytes of a target ByteChunk to be the bytes from a
     * source String. */
    @Test
    public void testByteChunkConverter() {
        String source = "testByteChunkConverter";
        ByteChunk target = new ByteChunk();
        target.setBytes("target".getBytes(), 0, "target".length());
        ByteChunk result =  (ByteChunk)ByteChunkConverter.getInstance().convert(target, source);
        assertSame(target, result); // Check the conversion was in-place
        assertTrue(result.equals(source));
    }
}