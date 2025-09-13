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

import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:padreati@yahoo.com">Aurelian Tutuianu</a> at 11/4/14.
 */
public class UniformTest {


    @Test
    public void testCycle() {
        Iterable<String> cycle = Iterables.cycle("a", "b");
        int howManyChecked = 0;
        for (String string : cycle) {
        String expected = (howManyChecked % 2 == 0) ? "a" : "b";
        assertEquals(expected, string);
        if (howManyChecked++ == 5) {
            break;
        }
        }
        // We left the last iterator pointing to "b". But a new iterator should
        // always point to "a".
        for (String string : cycle) {
        assertEquals("a", string);
        break;
        }
        assertEquals("[a, b] (cycled)", cycle.toString());
    }
}