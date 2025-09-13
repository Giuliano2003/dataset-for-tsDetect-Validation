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
    public void testConcatIterable() {
        List<Integer> list1 = newArrayList(1);
        List<Integer> list2 = newArrayList(4);
        List<List<Integer>> input = newArrayList(list1, list2);
        Iterable<Integer> result = Iterables.concat(input);
        assertEquals(asList(1, 4), newArrayList(result));
        // Now change the inputs and see result dynamically change as well
        list1.add(2);
        List<Integer> list3 = newArrayList(3);
        input.add(1, list3);
        assertEquals(asList(1, 2, 3, 4), newArrayList(result));
        assertEquals("[1, 2, 3, 4]", result.toString());
  }
}