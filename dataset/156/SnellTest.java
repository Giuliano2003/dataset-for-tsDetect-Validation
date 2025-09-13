import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mtumilowicz on 2018-11-13.
 */
public class LambdaCompilationTest {

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