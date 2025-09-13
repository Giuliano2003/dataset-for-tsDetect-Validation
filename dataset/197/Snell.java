import java.util.*;

public class Deck{

  public ArrayList<Card> deck = new ArrayList<Card>(); // change to private after testing

  public Deck(){
    deckBuilder();
  }

  private void deckBuilder(){
    for (Suit suit : Suit.values()){
      for (Value value : Value.values()){
        deck.add(new Card(suit, value));
      }
    }
  }

  public Card getCard(int id){
    return deck.get(id);
  }

  public void shuffle(){
    Collections.shuffle(deck);
  }
  
  public void dealCards(ArrayList<Card> hand, int num){
    for (int i = 0 ; i < num; i++){
      hand.add(deck.remove(0));
    }
  }
}