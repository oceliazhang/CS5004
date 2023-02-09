import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {
    private Pawn myPawn = new Pawn(1,1,Color.WHITE);

    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        Pawn wrongPawn = new Pawn(2, -3, Color.BLACK);
    }

    @Test
    public void getRow() {
        assertEquals(1, myPawn.getRow());
    }

    @Test
    public void getColumn() {
        assertEquals(1, myPawn.getColumn());
    }

    @Test
    public void getColor() {
        assertEquals("WHITE", myPawn.getColor().toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void canMoveWrong() {
        myPawn.canMove(-1,0);
    }

    @Test
    public void canMove() {
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

    @Test
    public void canKill() {
        ChessPiece pieceA = new Pawn(2,2,Color.WHITE);
        assertFalse(myPawn.canKill(pieceA));
        ChessPiece pieceB = new Pawn(2,2,Color.BLACK);
        assertTrue(myPawn.canKill(pieceB));
        ChessPiece pieceC = new Pawn(2,5,Color.WHITE);
        assertFalse(myPawn.canKill(pieceC));
    }
}