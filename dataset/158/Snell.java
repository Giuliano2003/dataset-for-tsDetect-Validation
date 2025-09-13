import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck;

    // Constructor deck of playing cards
    // The deck contains 52 cards
    // Initially the cards are in a sorted order
    public Deck() {
        deck = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public int size(){
        return deck.size();
    }

    // get the card at the top of the deck last on the listarray.
    public Card getOneCard() {
        Card card;
        if ( !deck.isEmpty())
            card = deck.remove(deck.size() - 1);
        else
            card = null;
        return card;
    }

    public ArrayList<Card> deal(int numberOfCards){
        ArrayList<Card> cards = new ArrayList<Card>();
        for(int i=0; i<numberOfCards; ++i){
            cards.add(this.getOneCard());
        }
        return cards;
    }

    // shuffle() randomize the order
    // and resets to full deck
    public void shuffle() {
        for (int i = deck.size() - 1; i > 0; --i) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deck.get(i);
            deck.set(i, deck.get(rand));
            deck.set(rand, temp);
        }
    }

    // to be used by System.out.println() to print the whole deck one card per line
    public String toString() {
        StringBuilder deckString = new StringBuilder();
        for (Card card : deck)
            deckString.append(card.toString() + "\n");

        return deckString.toString();
    }
}