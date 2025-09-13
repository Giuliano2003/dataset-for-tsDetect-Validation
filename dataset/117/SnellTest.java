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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import rapaio.data.Frame;
import rapaio.data.Var;
import rapaio.data.VarType;
import rapaio.io.Csv;

public class ChiSquareTest {

    private static final double TOL = 1e-9;



    @Test
    public void testOtherChiSq() {
        ChiSquare c = ChiSquare.of(1);

        assertEquals("ChiSq(df=1)", c.name());
        assertFalse(c.discrete());
        assertEquals(0, c.minValue(), TOL);
        assertEquals(Double.POSITIVE_INFINITY, c.maxValue(), TOL);
        assertEquals(1, c.mean(), TOL);
        assertEquals(2, c.var(), TOL);
        assertEquals(0, c.mode(), TOL);
        assertEquals(2.8284271247461903, c.skewness(), TOL);
        assertEquals(12, c.kurtosis(), TOL);

        ChiSquare c1 = ChiSquare.of(1);
        Var sample1 = c1.sample(1000_000);
        assertEquals(sample1.size(), sample1.stream().mapToDouble().filter(x -> x > 0).count());

        ChiSquare c2 = ChiSquare.of(2);
        Var sample = c2.sample(100);
        long count = sample.stream().mapToDouble().filter(x -> x > 0).count();
        assertEquals(sample.size(), count);

        sample = c.sample(100);
        count = sample.stream().mapToDouble().filter(x -> x > 0).count();
        assertEquals(sample.size(), count);
        assertEquals(0, ChiSquare.of(2).pdf(-10), TOL);
        assertEquals(0, ChiSquare.of(3).cdf(-10), TOL);
    }


}