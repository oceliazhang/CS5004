import org.junit.Test;

import static org.junit.Assert.*;

public class BishopTest {
    private Bishop myBishop = new Bishop(0, 2, Color.BLACK);

    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        Bishop wrongBishop = new Bishop(2, -3, Color.BLACK);
    }

    @Test
    public void getRow() {
        assertEquals(0, myBishop.getRow());
    }

    @Test
    public void getColumn() {
        assertEquals(2, myBishop.getColumn());
    }

    @Test
    public void getColor() {
        assertEquals("BLACK", myBishop.getColor().toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void canMoveWrong() {
        myBishop.canMove(-1,0);
    }

    @Test
    public void canMove() {
        assertTrue(myBishop.canMove(1,3));
        assertFalse(myBishop.canMove(1,4));
    }

    @Test
    public void canKill() {
        ChessPiece pieceA = new Pawn(2,4,Color.BLACK);
        assertFalse(myBishop.canKill(pieceA));
        ChessPiece pieceB = new Pawn(2,4,Color.WHITE);
        assertTrue(myBishop.canKill(pieceB));
        ChessPiece pieceC = new Pawn(2,5,Color.BLACK);
        assertFalse(myBishop.canKill(pieceC));
    }
}