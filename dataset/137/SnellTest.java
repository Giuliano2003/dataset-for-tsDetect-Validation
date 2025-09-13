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
   public void testConsumingIterable() {
    // Test data
    List<String> list = Lists.newArrayList(asList("a", "b"));
    // Test & Verify
    Iterable<String> consumingIterable = Iterables.consumingIterable(list);
    assertEquals("Iterables.consumingIterable(...)", consumingIterable.toString());
    Iterator<String> consumingIterator = consumingIterable.iterator();
    assertThat(list).containsExactly("a", "b").inOrder();
    assertTrue(consumingIterator.hasNext());
    assertThat(list).containsExactly("a", "b").inOrder();
    assertEquals("a", consumingIterator.next());
    assertThat(list).contains("b");
    assertTrue(consumingIterator.hasNext());
    assertEquals("b", consumingIterator.next());
    assertThat(list).isEmpty();
    assertFalse(consumingIterator.hasNext());
  }
}