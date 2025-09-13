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
        range1 = new LongRange(1, 2);
        range2 = new LongRange(2, 3);
        range3 = new LongRange(3, 4);
        rangeFull = of(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    @Test
    public void testIsStartedBy() {
        assertFalse(range1.isStartedBy(null));

        assertFalse(range1.isStartedBy(5L));
        assertTrue(range1.isStartedBy(10L));
        assertFalse(range1.isStartedBy(15L));
        assertFalse(range1.isStartedBy(20L));
        assertFalse(range1.isStartedBy(25L));
    }

    @Test
    public void testIsWithCompareRange() {
        // all integers are equal
        final Comparator<Integer> c = (o1, o2) -> 0;
        Range<Integer> ri = Range.is(10);
        assertFalse(ri.contains(null));
        ri = Range.is(10, c);
        assertFalse(ri.contains(null));
    }


}