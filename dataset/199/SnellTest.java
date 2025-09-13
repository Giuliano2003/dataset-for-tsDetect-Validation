package onitama;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpotTest {
    private Piece pieces;
    private Piece piece2;
    Position positions;
    private Spot spotVazio;
    private Spot spotPiece;
    private  Spot spotBase;

    @Before
    public void setup() {
        pieces = new Piece(Color.BLUE, false);
        piece2 = new Piece(Color.RED, false);
        positions = new Position(0,0);
        spotVazio = new Spot(positions);
        spotPiece = new Spot(pieces, positions);
        spotBase = new Spot(pieces, positions, Color.BLUE);
    }
    @Test
    public void testConstructor_Spot() {
        Position expectedPosition = new Position(1, 1);
        Spot spot = new Spot(expectedPosition);

        assertEquals(expectedPosition,spot.getPos());
        assertNull(spot.getPiece());
        assertNull(spot.getColor());
    }
    @Test
    public void testConstructor_SpotWithPiece() {
        Position expectedPosition = new Position(1, 1);
        Piece expectedPiece = new Piece(Color.BLUE, false);
        Spot spot = new Spot(expectedPiece,expectedPosition);

        assertEquals(expectedPosition,spot.getPos());
        assertEquals(expectedPiece,spot.getPiece());
        assertNull(spot.getColor());
    }
    @Test
    public void testConstructor_SpotWithBase() {
        Position expectedPosition = new Position(1, 1);
        Piece expectedPiece = new Piece(Color.BLUE, false);
        Color expectedColor = Color.RED;
        Spot spot = new Spot(expectedPiece,expectedPosition,expectedColor);

        assertEquals(expectedPosition,spot.getPos());
        assertEquals(expectedPiece,spot.getPiece());
        assertEquals(expectedColor, spot.getColor());
    }
    @Test
    public void getPiece() {
        Piece p = new Piece(Color.RED, true);
        assertNotEquals(p, spotPiece.getPiece());
        assertNotEquals(p, spotBase.getPiece());
        assertNull(spotVazio.getPiece());

        assertEquals(pieces, spotPiece.getPiece());
        assertEquals(pieces, spotBase.getPiece());

    }

}