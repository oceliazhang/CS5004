import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {
    private Queen myQueen = new Queen(0,3,Color.BLACK);
    private Queen otherQueen = new Queen(1,1,Color.WHITE);

    /**
     * test constructor.
     * if row or column out of range, throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        Queen wrongQueen = new Queen(2, -3, Color.BLACK);
    }

    /**
     * test getRow() method
     */
    @Test
    public void testGetRow() {

        assertEquals(0, myQueen.getRow());
        assertEquals(1, otherQueen.getRow());
    }

    /**
     * test getColumn() method
     */
    @Test
    public void testGetColumn() {

        assertEquals(3, myQueen.getColumn());
        assertEquals(1, otherQueen.getColumn());
    }

    /**
     * test getColor() method
     */
    @Test
    public void testGetColor() {

        assertEquals("BLACK", myQueen.getColor().toString());
        assertEquals("WHITE", otherQueen.getColor().toString());
    }

    /**
     * test canMove() method,
     * if row or column out of range, throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCanMoveWrong() {
        myQueen.canMove(-1,0);
    }

    /**
     * test canMove() method
     */
    @Test
    public void testCanMove() {
        assertTrue(myQueen.canMove(2,1));
        assertFalse(myQueen.canMove(1,5));
        assertTrue(otherQueen.canMove(2,1));
        assertFalse(otherQueen.canMove(0,5));
    }

    /**
     * test canKill() method
     */
    @Test
    public void testCanKill() {
        ChessPiece pieceA = new Pawn(2,1,Color.BLACK);
        assertFalse(myQueen.canKill(pieceA));
        ChessPiece pieceB = new Pawn(2,1,Color.WHITE);
        assertTrue(myQueen.canKill(pieceB));
        ChessPiece pieceC = new Pawn(1,5,Color.BLACK);
        assertFalse(myQueen.canKill(pieceC));
    }

    /**
     * test toString() method
     */
    @Test
    public void testToString() {
        assertEquals("Queen{row=0, column=3, color=BLACK}",
            myQueen.toString());
        assertEquals("Queen{row=1, column=1, color=WHITE}",
            otherQueen.toString());
    }
}