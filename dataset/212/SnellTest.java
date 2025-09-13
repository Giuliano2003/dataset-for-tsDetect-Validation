/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.lang3;

import static org.apache.commons.lang3.LangAssertions.assertIllegalArgumentException;
import static org.apache.commons.lang3.LangAssertions.assertNullPointerException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import java.util.stream.LongStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests {@link LongRange}.
 */
@SuppressWarnings("boxing")
class LongRangeTest extends AbstractLangTest {

    private static LongRange of(final int min, final int max) {
        return LongRange.of(min, max);
    }

    private static LongRange of(final Long min, final Long max) {
        return LongRange.of(min, max);
    }

    private LongRange range1;

    private LongRange range2;

    private LongRange range3;

    private LongRange rangeFull;

    @BeforeEach
    public void setUp() {
        range1 = of(10, 20);
        range2 = of(10, 20);
        range3 = of(-2, -1);
        rangeFull = of(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    
    @Test
    public void testIsAfter() {
        assertFalse(range1.isAfter(null));

        assertTrue(range1.isAfter(5L));
        assertFalse(range1.isAfter(10L));
        assertFalse(range1.isAfter(15L));
        assertFalse(range1.isAfter(20L));
        assertFalse(range1.isAfter(25L));
    }

    @Test
    public void testIsAfterRange() {
        assertFalse(range1.isAfterRange(null));

        assertTrue(range1.isAfterRange(Range.of(5L, 9L)));

        assertFalse(range1.isAfterRange(Range.of(5L, 10L)));
        assertFalse(range1.isAfterRange(Range.of(5L, 20L)));
        assertFalse(range1.isAfterRange(Range.of(5L, 25L)));
        assertFalse(range1.isAfterRange(Range.of(15L, 25L)));

        assertFalse(range1.isAfterRange(Range.of(21L, 25L)));

        assertFalse(range1.isAfterRange(Range.of(10L, 20L)));
    }

    @Test
    public void testIsBefore() {
        assertFalse(range1.isBefore(null));

        assertFalse(range1.isBefore(5L));
        assertFalse(range1.isBefore(10L));
        assertFalse(range1.isBefore(15L));
        assertFalse(range1.isBefore(20L));
        assertTrue(range1.isBefore(25L));
    }

    @Test
    public void testIsBeforeIntegerRange() {
        assertFalse(range1.isBeforeRange(null));

        assertFalse(range1.isBeforeRange(of(5, 9)));

        assertFalse(range1.isBeforeRange(of(5, 10)));
        assertFalse(range1.isBeforeRange(of(5, 20)));
        assertFalse(range1.isBeforeRange(of(5, 25)));
        assertFalse(range1.isBeforeRange(of(15, 25)));

        assertTrue(range1.isBeforeRange(of(21, 25)));

        assertFalse(range1.isBeforeRange(of(10, 20)));
    }
}