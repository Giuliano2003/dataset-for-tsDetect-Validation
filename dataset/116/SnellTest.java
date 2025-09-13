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
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rapaio.data.Frame;
import rapaio.data.Var;
import rapaio.io.Csv;

/**
 * Test for binomial distribution
 * @author <a href="mailto:padreati@yahoo.com">Aurelian Tutuianu</a> on 7/17/16.
 */
public class BinomialTest {

    private static final double TOL = 1e-12;
    private Frame df;

    @BeforeEach
    public void setUp() throws Exception {
        df = Csv.instance()
                .header.set(true)
                .quotes.set(false)
                .read(BinomialTest.class, "binom.csv");
    }

    @Test
    public void nameTest() {
        assertEquals("Binomial(p=0.5,n=10)", Binomial.of(0.5, 10).name());
    }

    @Test
    public void bigN() {
        Binomial b = Binomial.of(0.5, 10000000);
        assertEquals(10000000. / 2, b.quantile(0.5), TOL);
    }

    @Test
    public void testVariousArtifacts() {

        Binomial b = Binomial.of(0.2, 120);
        assertTrue(b.discrete());
        assertEquals(0, b.minValue(), TOL);
        assertEquals(120, b.maxValue(), TOL);
        assertEquals(24, b.mean(), TOL);
        assertEquals(24, b.mode(), TOL);
        assertEquals(19.2, b.var(), TOL);

        assertEquals(0.13693063937629152, b.skewness(), TOL);
        assertEquals(0.0020833333333333233, b.kurtosis(), TOL);
        assertEquals(4.1786127880975386, b.entropy(), TOL);
    }

    @Test
    public void testBinomialPdf() {

        Binomial b1 = Binomial.of(0.1, 10);
        Binomial b2 = Binomial.of(0.1, 100);
        Binomial b3 = Binomial.of(0.9, 100);
        Binomial b4 = Binomial.of(0.9, 2000);

        Var x = df.rvar("x");

        Var pdf1 = df.rvar("pdf_10_0.1");
        Var pdf2 = df.rvar("pdf_100_0.1");
        Var pdf3 = df.rvar("pdf_100_0.9");
        Var pdf4 = df.rvar("pdf_2000_0.9");

        for (int i = 0; i < df.rowCount(); i++) {
            assertEquals(pdf1.getDouble(i), b1.pdf(x.getDouble(i)), TOL);
            assertEquals(pdf2.getDouble(i), b2.pdf(x.getDouble(i)), TOL);
            assertEquals(pdf3.getDouble(i), b3.pdf(x.getDouble(i)), TOL);
            assertEquals(pdf4.getDouble(i), b4.pdf(x.getDouble(i)), TOL);
        }
    }
}