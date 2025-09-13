import static org.junit.Assert.*;
import org.junit.*;

public class DeckTest {
  Deck testDeck;
  Card aceOfSpacesMaybe;

  @Before
  public void before(){
    testDeck = new Deck();
    aceOfSpacesMaybe = new Card(Suit.SPADE, Value.ACE);
  }

  @Test
  public void deckHas52Cards(){
    assertEquals(52, testDeck.deck.size());
  }

  @Test
  public void canGetCard(){
    assertEquals(Suit.DIAMOND, testDeck.getCard(0).getSuit());
  }

}