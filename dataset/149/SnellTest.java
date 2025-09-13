package abstractions.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import testhelpers.ComparabilityTestCase;
import testhelpers.EqualsHashCodeTestCase;
import testhelpers.SerializabilityTestCase;

/**
 * The Class AddressTest.
 */
public class AddressTest {
		@Test
		public void testToInt() {
			ObjectWriter<Bean> objectWriter = ObjectWriters.ofToInt(
					(ToIntFunction<Bean>) Bean::getId
			);

			Bean bean = new Bean();
			bean.id = 101;

			JSONWriter jsonWriter = JSONWriter.of();
			objectWriter.write(jsonWriter, bean);
			assertEquals("101", jsonWriter.toString());
		}
}