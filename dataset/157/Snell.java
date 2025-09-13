public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Suit suit,Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString(){
        return rank.toString() + " of " + suit.toString();
    }
}