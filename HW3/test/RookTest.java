import org.junit.Test;

import static org.junit.Assert.*;

public class RookTest {
    private Rook myRook = new Rook(0,0,Color.BLACK);
    private Rook otherRook = new Rook(1,1,Color.WHITE);

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
        assertEquals(1, otherRook.getRow());
    }

    /**
     * test getColumn() method
     */
    @Test
    public void testGetColumn() {

        assertEquals(0, myRook.getColumn());
        assertEquals(1, otherRook.getRow());
    }

    /**
     * test getColor() method
     */
    @Test
    public void testGetColor() {

        assertEquals("BLACK", myRook.getColor().toString());
        assertEquals("WHITE", otherRook.getColor().toString());
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
        assertTrue(otherRook.canMove(1,0));
        assertFalse(otherRook.canMove(2,4));
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

    /**
     * test toString() method
     */
    @Test
    public void testToString() {
        assertEquals("Rook{row=0, column=0, color=BLACK}",
            myRook.toString());
        assertEquals("Rook{row=1, column=1, color=WHITE}",
            otherRook.toString());
    }
}