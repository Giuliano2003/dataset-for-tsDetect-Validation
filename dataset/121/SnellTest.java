/*
 * Apache License
 * Version 2.0, January 2004
 * http://www.apache.org/licenses/
 *
 *    Copyright 2013 - 2025 Aurelian Tutuianu
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package rapaio.core.distributions;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rapaio.data.Frame;
import rapaio.io.Csv;

public class HypergeometricTest {

    private static final double TOL = 1e-15;

    private Frame df;
    private Hypergeometric hg1;
    private Hypergeometric hg2;

    @Before
    public void beforeEach() throws Exception {
        df = Csv.instance().naValues.set("NaN").read(HypergeometricTest.class, "hyper.csv");

        hg1 = Hypergeometric.of(20, 20, 30);
        hg2 = Hypergeometric.of(70, 70, 100);
    }

    @Test
    public void testGeneric() {
        Hypergeometric hg = Hypergeometric.of(10, 10, 6);
        assertEquals("Hypergeometric(m=10,n=10,k=6)", hg.name());
        assertTrue(hg1.discrete());

        assertEquals(0, hg1.cdf(Double.NEGATIVE_INFINITY), TOL);
        assertEquals(1, hg1.cdf(Double.POSITIVE_INFINITY), TOL);
        assertEquals(1, hg1.cdf(32), TOL);

        assertEquals(0, hg1.minValue(), TOL);
        assertEquals(20, hg1.maxValue(), TOL);
        assertEquals(15, hg1.mean(), TOL);
        assertEquals(15, hg1.mode(), TOL);
        assertEquals(1.9230769230769231, hg1.var(), TOL);
        assertEquals(0.018027756377319945, hg1.skewness(), TOL);
        assertEquals(-0.11891891891891893, hg1.kurtosis(), TOL);
        assertEquals(Double.NaN, hg1.entropy(), TOL); // not implemented
    }
}