import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {
    private Queen myQueen = new Queen(0,3,Color.BLACK);

    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        Queen wrongQueen = new Queen(2, -3, Color.BLACK);
    }

    @Test
    public void getRow() {
        assertEquals(0, myQueen.getRow());
    }

    @Test
    public void getColumn() {
        assertEquals(3, myQueen.getColumn());
    }

    @Test
    public void getColor() {
        assertEquals("BLACK", myQueen.getColor().toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void canMoveWrong() {
        myQueen.canMove(-1,0);
    }

    @Test
    public void canMove() {
        assertTrue(myQueen.canMove(2,1));
        assertFalse(myQueen.canMove(1,5));
    }

    @Test
    public void canKill() {
        ChessPiece pieceA = new Pawn(2,1,Color.BLACK);
        assertFalse(myQueen.canKill(pieceA));
        ChessPiece pieceB = new Pawn(2,1,Color.WHITE);
        assertTrue(myQueen.canKill(pieceB));
        ChessPiece pieceC = new Pawn(1,5,Color.BLACK);
        assertFalse(myQueen.canKill(pieceC));
    }
}