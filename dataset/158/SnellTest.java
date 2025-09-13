import org.junit.Test;
import static org.junit.Assert.* ;

public class DeckTest {
    @Test
    public void testGetOneCard() throws Exception {
        Deck deck = new Deck();
        Card card = deck.getOneCard();
        assertEquals("King of Clubs",card.toString());

    }

    @Test
    public void testLastOneCard() throws Exception {
        Deck deck = new Deck();
        int size=deck.size();
        for(int i=0; i<size;++i)
          deck.getOneCard();
        Card card = deck.getOneCard();
        assertNull(card);
    }

}