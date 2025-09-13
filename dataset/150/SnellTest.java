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
		public void testJsonStyle() {
			TestJsonStyle jsonStyle = new TestJsonStyle();
			jsonStyle.setA("测试");
			Assertions.assertEquals("{\"a\":\"测试\"}",jsonStyle.toString());
		}
}