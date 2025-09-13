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
		@Before
		public void setUp() throws Exception {
			address = new Address.Builder().address1("9839 Carlisle Boulevard NE").city("Albuquerque").state("NM").zip("87110").build();
		}

	
		@Test
		public void testBuilder() {
			assertThat(address.getAddress1(), is("9839 Carlisle Boulevard NE"));
			assertThat(address.getCity(), is("Albuquerque"));
			assertThat(address.getState(), is("NM"));
			assertThat(address.getZip(), is("87110"));
		}

		@Test
		public void testToString() {
			assertThat(address.toString(), is("Address{9839 Carlisle Boulevard NE, Albuquerque, NM, 87110}"));
		}
}