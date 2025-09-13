import org.junit.Test;
import static org.junit.Assert.* ;

public class CardTest {
    @Test
    public void testToString() throws Exception {
        Card card = new Card(Suit.CLUBS,Rank.ACE);
        assertEquals("Ace of Clubs",card.toString());
    }
}