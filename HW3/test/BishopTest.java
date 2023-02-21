import org.junit.Test;

import static org.junit.Assert.*;

public class BishopTest {
    private Bishop myBishop = new Bishop(0, 2, Color.BLACK);

    /**
     * test constructor.
     * if row or column out of range, throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        Bishop wrongBishop = new Bishop(2, -3, Color.BLACK);
    }

    /**
     * test getRow() method
     */
    @Test
    public void testGetRow() {
        assertEquals(0, myBishop.getRow());
    }

    /**
     * test getColumn() method
     */
    @Test
    public void testGetColumn() {
        assertEquals(2, myBishop.getColumn());
    }

    /**
     * test getColor() method
     */
    @Test
    public void testGetColor() {
        assertEquals("BLACK", myBishop.getColor().toString());
    }

    /**
     * test canMove() method,
     * if row or column out of range, throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCanMoveWrong() {
        myBishop.canMove(-1,0);
    }

    /**
     * test canMove() method
     */
    @Test
    public void testCanMove() {
        assertTrue(myBishop.canMove(1,3));
        assertFalse(myBishop.canMove(1,4));
    }

    /**
     * test canKill() method
     */
    @Test
    public void testCanKill() {
        ChessPiece pieceA = new Pawn(2,4,Color.BLACK);
        assertFalse(myBishop.canKill(pieceA));
        ChessPiece pieceB = new Pawn(2,4,Color.WHITE);
        assertTrue(myBishop.canKill(pieceB));
        ChessPiece pieceC = new Pawn(2,5,Color.BLACK);
        assertFalse(myBishop.canKill(pieceC));
    }

    /**
     * test toString() method
     */
    @Test
    public void testToString() {
        assertEquals("Bishop{row=0, column=2, color=BLACK}",
            myBishop.toString());
    }
}