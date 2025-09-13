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
    public void getPos() {
        assertEquals(positions, spotVazio.getPos());
        assertEquals(positions, spotBase.getPos());
        assertEquals(positions, spotPiece.getPos());
        Position fakePosition = new Position(1,1);
        assertNotEquals(fakePosition, spotVazio.getPos());
        assertNotEquals(fakePosition, spotBase.getPos());
        assertNotEquals(fakePosition, spotPiece.getPos());

    }

    @Test
    public void getColor() {
        assertNull(spotVazio.getColor());
        assertNull(spotPiece.getColor());
        assertEquals(Color.BLUE, spotBase.getColor());
    }



}