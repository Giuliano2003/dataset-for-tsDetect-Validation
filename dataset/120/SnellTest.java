
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

import static java.lang.Math.sqrt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rapaio.core.tests.KSTestOneSample;
import rapaio.data.Frame;
import rapaio.data.Mapping;
import rapaio.data.Var;
import rapaio.io.Csv;

public class GammaTest {

    private static final double TOL = 1e-13;
    private Frame df;
    private Gamma g_low_low;
    private Gamma g_one_low;
    private Gamma g_high_low;
    private Gamma g_low_one;
    private Gamma g_one_one;
    private Gamma g_high_one;
    private Gamma g_low_high;
    private Gamma g_one_high;
    private Gamma g_high_high;

    @Before
    public void beforeEach() throws IOException {
        df = Csv.instance().naValues.set("NaN").read(HypergeometricTest.class, "gamma.csv").mapRows(Mapping.range(1_000));
        g_low_low = Gamma.of(0.5, 0.5);
        g_one_low = Gamma.of(0.5, 1);
        g_high_low = Gamma.of(0.5, 5);
        g_low_one = Gamma.of(1, 0.5);
        g_one_one = Gamma.of(1, 1);
        g_high_one = Gamma.of(1, 5);
        g_low_high = Gamma.of(5, 0.5);
        g_one_high = Gamma.of(5, 1);
        g_high_high = Gamma.of(5, 5);
    }


    @Test
    public void testMiscelaneous() {
        Gamma g = Gamma.of(0.5, 0.5);

        assertFalse(g.discrete());
        assertEquals("Gamma(alpha=0.5, beta=0.5)", g.name());
        assertEquals(0, g.minValue(), TOL);
        assertEquals(Double.POSITIVE_INFINITY, g.maxValue(), TOL);
        assertEquals(Double.NaN, g.pdf(-1), TOL);
        assertEquals(0, g.cdf(-1), TOL);
        assertEquals(Double.NaN, g.mode(), TOL);

        assertEquals(1.5, Gamma.of(3, 2).mean(), TOL);
        assertEquals(sqrt(2), Gamma.of(3, 2).skewness(), TOL);
        assertEquals(3 / 4., Gamma.of(3, 2).var(), TOL);
        assertEquals(2, Gamma.of(3, 2).kurtosis(), TOL);
    }



}
