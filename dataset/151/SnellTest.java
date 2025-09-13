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
    public void testLANG1395() {
        assertEquals("{\"name\":\"value\"}", new ToStringBuilder(base).append("name", "value").toString());
        assertEquals("{\"name\":\"\"}", new ToStringBuilder(base).append("name", "").toString());
        assertEquals("{\"name\":\"\"\"}", new ToStringBuilder(base).append("name", '"').toString());
        assertEquals("{\"name\":\"\\\"}", new ToStringBuilder(base).append("name", '\\').toString());
        assertEquals("{\"name\":\"Let's \"quote\" this\"}", new ToStringBuilder(base).append("name", "Let's \"quote\" this").toString());

    }
}