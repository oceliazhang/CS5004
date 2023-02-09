import org.junit.Test;

import static org.junit.Assert.*;

public class KnightTest {
    private Knight myKnight = new Knight(0, 1, Color.BLACK);

    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        Knight wrongKnight = new Knight(2, -3, Color.BLACK);
    }

    @Test
    public void getRow() {
        assertEquals(0, myKnight.getRow());
    }

    @Test
    public void getColumn() {
        assertEquals(1, myKnight.getColumn());
    }

    @Test
    public void getColor() {
        assertEquals("BLACK", myKnight.getColor().toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void canMoveWrong() {
        myKnight.canMove(-1,0);
    }

    @Test
    public void canMove() {
        assertTrue(myKnight.canMove(2,2));
        assertFalse(myKnight.canMove(1,4));
    }

    @Test
    public void canKill() {
        ChessPiece pieceA = new Pawn(2,2,Color.BLACK);
        assertFalse(myKnight.canKill(pieceA));
        ChessPiece pieceB = new Pawn(2,2,Color.WHITE);
        assertTrue(myKnight.canKill(pieceB));
        ChessPiece pieceC = new Pawn(2,5,Color.BLACK);
        assertFalse(myKnight.canKill(pieceC));
    }
}