import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {
    private Pawn myPawn = new Pawn(1,1,Color.WHITE);

    /**
     * test constructor.
     * if row or column out of range, throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        Pawn wrongPawn = new Pawn(2, -3, Color.BLACK);
    }

    /**
     * test getRow() method
     */
    @Test
    public void testGetRow() {
        assertEquals(1, myPawn.getRow());
    }

    /**
     * test getColumn() method
     */
    @Test
    public void testGetColumn() {
        assertEquals(1, myPawn.getColumn());
    }

    /**
     * test getColor() method
     */
    @Test
    public void testGetColor() {
        assertEquals("WHITE", myPawn.getColor().toString());
    }

    /**
     * test canMove() method,
     * if row or column out of range, throws IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCanMoveWrong() {
        myPawn.canMove(-1,0);
    }

    /**
     * test canMove() method
     */
    @Test
    public void testCanMove() {
        // white pawn test
        assertTrue(myPawn.canMove(2,1));
        assertTrue(myPawn.canMove(2,2));
        assertFalse(myPawn.canMove(0,1));

        // black pawn test
        Pawn blackPawn = new Pawn(6 ,2, Color.BLACK);
        assertTrue(blackPawn.canMove(5,2));
        assertTrue(blackPawn.canMove(5,1));
        assertFalse(blackPawn.canMove(7,2));
    }

    /**
     * test canKill() method
     */
    @Test
    public void testCanKill() {
        ChessPiece pieceA = new Pawn(2,2,Color.WHITE);
        assertFalse(myPawn.canKill(pieceA));
        ChessPiece pieceB = new Pawn(2,2,Color.BLACK);
        assertTrue(myPawn.canKill(pieceB));
        ChessPiece pieceC = new Pawn(2,5,Color.WHITE);
        assertFalse(myPawn.canKill(pieceC));
    }
}