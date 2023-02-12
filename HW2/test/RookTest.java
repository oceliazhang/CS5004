import org.junit.Test;

import static org.junit.Assert.*;

public class RookTest {
    private Rook myRook = new Rook(0,0,Color.BLACK);

    /**
     * test constructor.
     * if row or column out of range, throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        Rook wrongRook = new Rook(2, -3, Color.BLACK);
    }

    /**
     * test getRow() method
     */
    @Test
    public void testGetRow() {
        assertEquals(0, myRook.getRow());
    }

    /**
     * test getColumn() method
     */
    @Test
    public void testGetColumn() {
        assertEquals(0, myRook.getColumn());
    }

    /**
     * test getColor() method
     */
    @Test
    public void testGetColor() {
        assertEquals("BLACK", myRook.getColor().toString());
    }

    /**
     * test canMove() method,
     * if row or column out of range, throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCanMoveWrong() {
        myRook.canMove(-1,0);
    }

    /**
     * test canMove() method
     */
    @Test
    public void testCanMove() {
        assertTrue(myRook.canMove(2,0));
        assertFalse(myRook.canMove(1,4));
    }

    /**
     * test canKill() method
     */
    @Test
    public void testCanKill() {
        ChessPiece pieceA = new Pawn(0,2,Color.BLACK);
        assertFalse(myRook.canKill(pieceA));
        ChessPiece pieceB = new Pawn(0,2,Color.WHITE);
        assertTrue(myRook.canKill(pieceB));
        ChessPiece pieceC = new Pawn(2,5,Color.BLACK);
        assertFalse(myRook.canKill(pieceC));
    }
}