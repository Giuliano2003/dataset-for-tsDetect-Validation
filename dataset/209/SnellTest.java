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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests {@link Range}.
 */
@SuppressWarnings("boxing")
class RangeTest extends AbstractLangTest {

    abstract static class AbstractComparable implements Comparable<AbstractComparable> {
        @Override
        public int compareTo(final AbstractComparable o) {
            return 0;
        }
    }
    static final class DerivedComparableA extends AbstractComparable {
        // empty
    }
    static final class DerivedComparableB extends AbstractComparable {
        // empty
    }

    private Range<Byte> byteRange;
    private Range<Byte> byteRange2;
    private Range<Byte> byteRange3;
    private Range<Double> doubleRange;
    private Range<Float> floatRange;
    private Range<Integer> intRange;
    private Range<Long> longRange;

    @Before
    public void setUp() {
        byteRange = Range.of((byte) 0, (byte) 5);
        byteRange2 = Range.of((byte) 0, (byte) 5);
        byteRange3 = Range.of((byte) 0, (byte) 10);

        intRange = Range.of(10, 20);
        longRange = Range.of(10L, 20L);
        floatRange = Range.of((float) 10, (float) 20);
        doubleRange = Range.of((double) 10, (double) 20);
    }

    @Test
    public void testBetweenWithCompare() {
        // all integers are equal
        final Comparator<Integer> c = (o1, o2) -> 0;
        final Comparator<String> lengthComp = Comparator.comparingInt(String::length);
        Range<Integer> rb = Range.between(-10, 20);
        assertFalse(rb.contains(null), "should not contain null");
        assertTrue(rb.contains(10), "should contain 10");
        assertTrue(rb.contains(-10), "should contain -10");
        assertFalse(rb.contains(21), "should not contain 21");
        assertFalse(rb.contains(-11), "should not contain -11");
        rb = Range.between(-10, 20, c);
        assertFalse(rb.contains(null), "should not contain null");
        assertTrue(rb.contains(10), "should contain 10");
        assertTrue(rb.contains(-10), "should contain -10");
        assertTrue(rb.contains(21), "should contain 21");
        assertTrue(rb.contains(-11), "should contain -11");
        Range<String> rbstr = Range.between("house", "i");
        assertFalse(rbstr.contains(null), "should not contain null");
        assertTrue(rbstr.contains("house"), "should contain house");
        assertTrue(rbstr.contains("i"), "should contain i");
        assertFalse(rbstr.contains("hose"), "should not contain hose");
        assertFalse(rbstr.contains("ice"), "should not contain ice");
        rbstr = Range.between("house", "i", lengthComp);
        assertFalse(rbstr.contains(null), "should not contain null");
        assertTrue(rbstr.contains("house"), "should contain house");
        assertTrue(rbstr.contains("i"), "should contain i");
        assertFalse(rbstr.contains("houses"), "should not contain houses");
        assertFalse(rbstr.contains(""), "should not contain ''");
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void testComparableConstructors() {
        final Comparable c = other -> 1;
        final Range r1 = Range.is(c);
        final Range r2 = Range.between(c, c);
        assertTrue(r1.isNaturalOrdering());
        assertTrue(r2.isNaturalOrdering());
    }

    @Test
    public void testConstructorSignatureWithAbstractComparableClasses() {
        final DerivedComparableA derivedComparableA = new DerivedComparableA();
        final DerivedComparableB derivedComparableB = new DerivedComparableB();

        final Range<AbstractComparable> mixed = Range.between(derivedComparableA, derivedComparableB, null);
        assertTrue(mixed.contains(derivedComparableA));

        final Range<AbstractComparable> same = Range.between(derivedComparableA, derivedComparableA, null);
        assertTrue(same.contains(derivedComparableA));

        final Range<DerivedComparableA> rangeA = Range.between(derivedComparableA, derivedComparableA, null);
        assertTrue(rangeA.contains(derivedComparableA));

        final Range<DerivedComparableB> rangeB = Range.is(derivedComparableB, null);
        assertTrue(rangeB.contains(derivedComparableB));
    }
}