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
    public void checkVictoryMasterRedKillBlue() {
        Player red = gameRed.getRedPlayer();
        Player blue = gameRed.getBluePlayer();

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,2));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(3,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,0));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(2,2));
        assertTrue(gameRed.checkVictory(red.getPieceColor()));
    }

    @Test
    public void checkVictoryMasterBlueKillRed() {
        Player red = gameRed.getRedPlayer();
        Player blue = gameRed.getBluePlayer();

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,2));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(3,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(1,2));
        assertTrue(gameRed.checkVictory(blue.getPieceColor()));
    }

}