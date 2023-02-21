import org.junit.Test;

import static org.junit.Assert.*;

public class KnightTest {
    private Knight myKnight = new Knight(0, 1, Color.BLACK);

    /**
     * test constructor.
     * if row or column out of range, throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        Knight wrongKnight = new Knight(2, -3, Color.BLACK);
    }

    /**
     * test getRow() method
     */
    @Test
    public void testGetRow() {
        assertEquals(0, myKnight.getRow());
    }

    /**
     * test getColumn() method
     */
    @Test
    public void testGetColumn() {
        assertEquals(1, myKnight.getColumn());
    }

    /**
     * test getColor() method
     */
    @Test
    public void testGetColor() {
        assertEquals("BLACK", myKnight.getColor().toString());
    }

    /**
     * test canMove() method,
     * if row or column out of range, throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCanMoveWrong() {
        myKnight.canMove(-1,0);
    }

    /**
     * test canMove() method
     */
    @Test
    public void testCanMove() {
        assertTrue(myKnight.canMove(2,2));
        assertFalse(myKnight.canMove(1,4));
    }

    /**
     * test canKill() method
     */
    @Test
    public void testCanKill() {
        ChessPiece pieceA = new Pawn(2,2,Color.BLACK);
        assertFalse(myKnight.canKill(pieceA));
        ChessPiece pieceB = new Pawn(2,2,Color.WHITE);
        assertTrue(myKnight.canKill(pieceB));
        ChessPiece pieceC = new Pawn(2,5,Color.BLACK);
        assertFalse(myKnight.canKill(pieceC));
    }

    /**
     * test toString() method
     */
    @Test
    public void testToString() {
        assertEquals("Knight{row=0, column=1, color=BLACK}",
            myKnight.toString());
    }
}