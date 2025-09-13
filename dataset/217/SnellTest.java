package onitama;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameImplTest {
    Position[] Tiger = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
    Position[] Dragon = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
    Position[] Frog = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
    Position[] Rabbit = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
    Position[] Crab = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
    Card [] cartasTeste = new Card[] {
            new Card("Tiger",Color.BLUE ,Tiger),
            new Card("Dragon",Color.BLUE ,Dragon),
            new Card("Frog",Color.BLUE ,Frog),
            new Card("Rabbit", Color.BLUE, Rabbit),
            new Card("Crab", Color.BLUE, Crab)
    };
    Card [] cartasTeste2 = new Card[] {
            new Card("Tiger",Color.RED ,Tiger),
            new Card("Dragon",Color.RED ,Dragon),
            new Card("Frog",Color.RED ,Frog),
            new Card("Rabbit", Color.RED, Rabbit),
            new Card("Crab", Color.RED, Crab)
    };
    GameImpl game = new GameImpl();
    GameImpl game2 = new GameImpl("Red","Blue");
    GameImpl gameBlue = new GameImpl("Red", "Blue", cartasTeste);
    GameImpl gameRed = new GameImpl("Red", "Blue", cartasTeste2);
    private Board TestBoard;

    @Before
    public void setup() {
        TestBoard = new Board();
    }

    @Test
    public void getSpotColorTest() {
        for(int row=0; row<5;row++){
            for(int col=0;col<5;col++){
                Spot spots1 = game.getBoard().getSpot()[row][col];
                if(spots1.getColor() != null){
                    if(row == 0 && col == 2)assertEquals(game.getSpotColor(new Position(row, col)), Color.BLUE);
                    if(row == 4 && col == 2)assertEquals(game.getSpotColor(new Position(row, col)), Color.RED);
                }else assertNull(game.getSpotColor(new Position(row, col)));
            }
        }
    }



    @Test
    public void getPiece() {
        for(int row=0; row<5;row++){
            for(int col=0;col<5;col++){
                Piece piece = game2.getBoard().getSpot()[row][col].getPiece();
                if(piece != null)assertEquals(game2.getPiece(new Position(row, col)), piece);
                else assertNull(game2.getPiece(new Position(row, col)));
            }
        }

    }

    @Test
    public void getTableCard() {
        boolean diferente = true;
        Card red[] = gameBlue.getRedPlayer().getCards();
        Card blue[] = gameBlue.getBluePlayer().getCards();
        for(Card cards : red){
            if(cards == game.getTableCard())diferente = false;
        }
        for(Card cards : blue){
            if(cards == game.getTableCard())diferente = false;
        }
        assertTrue(diferente);

	}
}