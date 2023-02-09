import org.junit.Test;

import static org.junit.Assert.*;

public class RookTest {
    private Rook myRook = new Rook(0,0,Color.BLACK);

    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        Rook wrongRook = new Rook(2, -3, Color.BLACK);
    }

    @Test
    public void getRow() {
        assertEquals(0, myRook.getRow());
    }

    @Test
    public void getColumn() {
        assertEquals(0, myRook.getColumn());
    }

    @Test
    public void getColor() {
        assertEquals("BLACK", myRook.getColor().toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void canMoveWrong() {
        myRook.canMove(-1,0);
    }

    @Test
    public void canMove() {
        assertTrue(myRook.canMove(2,0));
        assertFalse(myRook.canMove(1,4));
    }

    @Test
    public void canKill() {
        ChessPiece pieceA = new Pawn(0,2,Color.BLACK);
        assertFalse(myRook.canKill(pieceA));
        ChessPiece pieceB = new Pawn(0,2,Color.WHITE);
        assertTrue(myRook.canKill(pieceB));
        ChessPiece pieceC = new Pawn(2,5,Color.BLACK);
        assertFalse(myRook.canKill(pieceC));
    }
}