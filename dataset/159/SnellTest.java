import org.junit.Test;
import static org.junit.Assert.* ;

public class SuitTest {
    @Test
    public void testToString() throws Exception {
       assertEquals("Hearts",Suit.HEARTS.toString());
    }
}