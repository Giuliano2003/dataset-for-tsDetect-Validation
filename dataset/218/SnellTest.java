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
    public void getRedPlayer() {
        assertNotEquals(gameRed.getRedPlayer().getName(), "Blue");
        assertNull(game.getRedPlayer().getName());
    }

    @Test
    public void getBluePlayer() {
        assertEquals(gameBlue.getBluePlayer().getName(), "Blue");
        assertNotEquals(gameBlue.getBluePlayer().getName(), "Red");
        assertNull(game.getBluePlayer().getName());
    }


    @Test
    public void makeMove() {
        Player red = gameRed.getRedPlayer();
        Card redCard = red.getCards()[0];
        Card troca = gameRed.getTableCard();
        gameRed.makeMove(redCard,redCard.getPosition()[0], new Position(4,0));
        assertEquals(gameRed.getTableCard(), redCard);
        assertEquals(red.getCards()[0], troca);

        Player blue = gameBlue.getBluePlayer();
        Card blueCard = blue.getCards()[0];
        troca = gameBlue.getTableCard();
        gameBlue.makeMove(blueCard,blueCard.getPosition()[1], new Position(0,0));
        assertEquals(gameBlue.getTableCard(), blueCard);
        assertEquals(blue.getCards()[0], troca);

        assertNotNull(gameBlue.getBoard().getSpot()[1][0].getPiece());
        assertNull(gameBlue.getBoard().getSpot()[0][0].getPiece());
    }
}